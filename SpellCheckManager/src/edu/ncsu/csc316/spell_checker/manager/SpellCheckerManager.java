package edu.ncsu.csc316.spell_checker.manager;

import edu.ncsu.csc316.spell_checker.counter.Counter;
import edu.ncsu.csc316.spell_checker.hash_table.HashTable;
import edu.ncsu.csc316.spell_checker.io.TextFileReader;
import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;
import edu.ncsu.csc316.spell_checker.rules.Rules;

/**
 * @author Nicholas Board (ndboard) The engine of the SpellCheckManager program.
 */
public class SpellCheckerManager {

	/** Contains all words in the dictionary. */
	private ArrayBasedList<String> dictionary;

	/** Contains all words in the input file. */
	private ArrayBasedList<String> input;
	
	/** HashTable containing words in the dictionary. */
	private HashTable hashDictionary;

	/** TextFileReader to scan both the dictionary and input file. */
	private TextFileReader fileReader;
	
	/** The counter to keep track of stats. */
	private Counter counter = new Counter();;
	
	/** Rules object, enables access to rules. */
	private Rules r;

	/**
	 * Constructs a new Spell Checker with the given dictionary
	 * 
	 * @param pathToDictionary
	 *            the path to the dictionary
	 */
	public SpellCheckerManager(String pathToDictionary) {
		
		fileReader = new TextFileReader(pathToDictionary);
		dictionary = fileReader.getWords();
		
		hashDictionary = new HashTable();
		hashDictionary.buildHashTable(dictionary);
	}

	/**
	 * Returns a string representation of the list of misspelled words (in
	 * alphabetical order, case insensitive) in the input file. The string
	 * representation should be in the format: ArrayBasedList[a, b, c]
	 * 
	 * @param pathToFile
	 *            the path to the file to be spell-checked
	 * @return a string representation of the list of misspelled words
	 */
	public String spellCheck(String pathToFile) {
		
		counter.resetCounter();
		fileReader = new TextFileReader(pathToFile);
		input = fileReader.getWords();
		String c;
		
		// First eight are used for telling if a rule is true, last one represents all rules
		boolean[] flags = new boolean[10];
		for(int i = 0; i < 10; i++)
			flags[i] = false;
		

		for( int i = 0; i < input.size(); i++ ) {
			
			// Look up original word.
			c = input.lookUp(i);
			if ( !inHashDictionary(c) ) {
				
				// Make first letter lowercase, lookup.
				c = r.CapitalizationRule(c);
				if( !inHashDictionary(c)) {
					
					// Remove -'s, then lookup.
					c = r.PossessionRule(c);
					if( !inHashDictionary(c)) {
						
						// Loop while not all flags are used
						while( !flags[9] ) {
							
							// Create a copy of c for comparison
							String d = c;
							
							// If word ends in -s and flag[0] isn't used
							// Check PluralityRule1
							if( c.charAt(c.length() - 1) == 's' && !flags[0] ) {
								
								 c = r.PluralityRule1(c);
								 
							}
							
							// If word ends in -es and flag[1] isn't used
							// Check PluralityRule2
							
							// If word ends in -r and flag[2] isn't used
							// Check OccupationRule1
							
							// If word ends in -er and flag[3] isn't used
							// Check OccupationRule2
							
							// If word ends in -d and flag[4] isn't used
							// Check PastTenseRule1
							
							// If words ends in -ed and flag[5] isn't used
							// Check PastTenseRule2
							
							// If word ends in -ing and flag[6] isn't used
							// Check GerundRule1
							
							// If word ends in -ing and flag[7 isn't used
							// Check GerundRule2
							
							// If word ends in -ly and flag[8] isn't used
							// Check AdverbRule
							
							// If flag[0-8] is used and word didn't change, set off flag[8]
							if( flags[0] && flags[1] && flags[2] && flags[3] && flags[4] && flags[5] && flags[6] && flags[7] && flags[8])
								flags[9] = true;
							
						}
					}
					else {
						
						// Remove -'s in dictionary.
					}
				}
				else {
					
					// First letter lowercase in dictionary.
				}
			}
			else {
				
				// Original word in dictionary.
				
			}
		}
		
		return pathToFile;
	}
	
	private boolean inHashDictionary(String c) {
		
		if( hashDictionary.lookUp(c).equals(c))
			return true;
		else
			return false;
	}
}
