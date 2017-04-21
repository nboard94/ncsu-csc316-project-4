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
		boolean flag1, flag2, flag3, flag4 = false;

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
