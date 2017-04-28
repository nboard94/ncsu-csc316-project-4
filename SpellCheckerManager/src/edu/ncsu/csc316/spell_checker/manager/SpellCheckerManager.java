package edu.ncsu.csc316.spell_checker.manager;

import edu.ncsu.csc316.spell_checker.counter.Counter;
import edu.ncsu.csc316.spell_checker.hash_table.HashTable;
import edu.ncsu.csc316.spell_checker.io.TextFileReader;
import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;
import edu.ncsu.csc316.spell_checker.rules.Rules;

/**
 * The engine of the SpellCheckManager program.
 * 
 * @author Nicholas Board (ndboard)
 */
public class SpellCheckerManager {

	/** Contains all words in the dictionary. */
	private ArrayBasedList<String> dictionary;

	/** Contains all words in the input file. */
	private ArrayBasedList<String> input;
	
	private ArrayBasedList<String> misspelled = new ArrayBasedList<String>();
	
	ArrayBasedList<String> mw;

	/** HashTable containing words in the dictionary. */
	private HashTable hashDictionary;

	/** HashTable containing all misspelled words. */
	private HashTable misspelledTable;

	/** TextFileReader to scan both the dictionary and input file. */
	private TextFileReader fileReader;

	/** The counter to keep track of stats. */
	private Counter counter = new Counter();

	/** Rules object, enables access to rules. */
	private Rules r = new Rules();

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

		misspelledTable = new HashTable();

		// Read the input file.
		fileReader = new TextFileReader(pathToFile);
		input = fileReader.getWords();

		// The Spell Checking Algorithm
		String c, d;
		boolean[] used;
		for (int i = 0; i < input.size(); i++) {

			// The word we are concerned with.
			c = input.lookUp(i);
			used = new boolean[10];

			// Lookup if original word is in dictionary.
			if (!inDict(c)) {

				// The original word is not in the dictionary.
				// Apply capitalization rule, and then lookup.
				c = r.capitalizationRule(c);
				if (!inDict(c)) {

					// Word with capitalization rule applied not in dictionary.
					// Apply possession rule, and then lookup.
					c = r.possessionRule(c);
					if (!inDict(c)) {

						// Word with possession rule applied not in dictionary.
						// Now apply the rest of the rules until we can no
						// longer.
						// The flags each represent whether a rule has been used
						// or not,
						// the last flag tells us if all the rules have been
						// exhausted.
						while (!used[9]) {

							// Use d to detect a change in the word this cycle.
							d = c;

							// Apply plurality rule 1, if it has not yet been
							// used.
							if (!used[0]) {

								c = r.pluralityRule1(c);

								// Check to see if the word was changed, if not
								// then we do not use this rule.
								// If so, look to see if it's in the dictionary
								// and mark rule as used.
								if (!c.equals(d)) {

									used[0] = true;
									if (inDict(c))
										break;
									else if (!used[1])
										c = d;
								}
							}

							// Apply plurality rule 2, if it has not yet been
							// used.
							if (!used[1]) {

								c = r.pluralityRule2(c);

								// Check to see if the word was changed, if not
								// then we do not use this rule.
								// If so, look to see if it's in the dictionary
								// and mark rule as used.
								if (!c.equals(d)) {

									used[1] = true;
									if (inDict(c))
										break;
									else if (!used[0])
										c = d;
								}
							}

							// Apply past tense rule 1, if it has not yet been
							// used.
							if (!used[2]) {

								c = r.pastTenseRule1(c);

								// Check to see if the word was changed, if not
								// then we do not use this rule.
								// If so, look to see if it's in the dictionary
								// and mark rule as used.
								if (!c.equals(d)) {

									used[2] = true;
									if (inDict(c))
										break;
									else if (!used[3])
										c = d;
								}
							}

							// Apply past tense rule 2, if it has not yet been
							// used.
							if (!used[3]) {

								c = r.pastTenseRule2(c);

								// Check to see if the word was changed, if not
								// then we do not use this rule.
								// If so, look to see if it's in the dictionary
								// and mark rule as used.
								if (!c.equals(d)) {

									used[3] = true;
									if (inDict(c))
										break;
									else if (!used[2])
										c = d;
								}
							}

							// Apply occupation rule 1, if it has not yet been
							// used.
							if (!used[4]) {

								c = r.occupationRule1(c);

								// Check to see if the word was changed, if not
								// then we do not use this rule.
								// If so, look to see if it's in the dictionary
								// and mark rule as used.
								if (!c.equals(d)) {

									used[4] = true;
									if (inDict(c))
										break;
									else if (!used[5])
										c = d;
								}
							}

							// Apply occupation rule 2, if it has not yet been
							// used.
							if (!used[5]) {

								c = r.occupationRule2(c);

								// Check to see if the word was changed, if not
								// then we do not use this rule.
								// If so, look to see if it's in the dictionary
								// and mark rule as used.
								if (!c.equals(d)) {

									used[5] = true;
									if (inDict(c))
										break;
									else if (!used[4])
										c = d;
								}
							}

							// Apply gerund rule 1, if it has not yet been used.
							if (!used[6]) {

								c = r.gerundRule1(c);

								// Check to see if the word was changed, if not
								// then we do not use this rule.
								// If so, look to see if it's in the dictionary
								// and mark rule as used.
								if (!c.equals(d)) {

									used[6] = true;
									if (inDict(c))
										break;
									else if (!used[7])
										c = d;
								}
							}

							// Apply gerund rule 2, if it has not yet been used.
							if (!used[7]) {

								c = r.gerundRule2(c);

								// Check to see if the word was changed, if not
								// then we do not use this rule.
								// If so, look to see if it's in the dictionary
								// and mark rule as used.
								if (!c.equals(d)) {

									used[7] = true;
									if (inDict(c))
										break;
									else if (!used[6])
										c = d;
								}
							}

							// Apply adverb rule, if it has not yet been used.
							if (!used[8]) {

								c = r.adverbRule(c);

								// Check to see if the word was changed, if not
								// then we do not use this rule.
								// If so, look to see if it's in the dictionary
								// and mark rule as used.
								if (!c.equals(d)) {

									used[8] = true;
									if (inDict(c))
										break;
								}
							}

							// If c has not been changed at all, none of the
							// rules can be applied, it is misspelled
							if (c.equals(d)) {

								used[9] = true;
								if (misspelledTable.lookUp(input.lookUp(i)) == null) {

									misspelledTable.insert(input.lookUp(i));
									misspelled.insert(input.lookUp(i));
								}
							}

							// TODO, I may need to check if all the rules have
							// been used and set used[9] to true manually.
							// I think that's taken care of when none of the
							// rules can be applied anymore, though.
						}
					}
				}
			}
		}

		// Sort out misspelled words.
		//TODO using bubble sort just to rule out Sorted.  Still isn't working.
		//Sorted s = new Sorted();
		
		mw = misspelled;

		for (int i = 0; i < mw.size(); i++) {

			for (int j = 1; j < (mw.size() - i); j++) {

				if (mw.lookUp(j - 1).compareToIgnoreCase(mw.lookUp(j)) > 1)
					mw.swap(j - 1, j);
			}
		}

		// Build and return the string of misspelled words.
		StringBuilder sb = new StringBuilder();
		sb.append("ArrayBasedList[");

		for (int i = 0; i < mw.size(); i++) {

			if (i == mw.size() - 1)
				sb.append(mw.lookUp(i));
			else
				sb.append(mw.lookUp(i) + ", ");
		}

		sb.append("]");
		return sb.toString();
	}

	private boolean inDict(String c) {

		if (hashDictionary.lookUp(c) == null)
			return false;
		else
			return hashDictionary.lookUp(c).equals(c);
	}
	
	/**
	 * This prints out the spellcheck report data.
	 * @return The string that represents the spellcheck report.
	 */
	public String report() {
		
		StringBuilder sb = new StringBuilder();

		sb.append("\nSpellCheck Report:\n");
		sb.append("Number of words in dictionary: " + this.dictionary.size() + "\n");
		sb.append("Number of words to spellcheck: " + this.input.size() + "\n");
		sb.append("Number of words misspelled: " + this.mw.size() + "\n");
		sb.append("Total number of probes: " + this.counter.getTotalProbes() + "\n");
		sb.append("Total number of lookups: " + this.counter.getTotalLookUps() + "\n");
		
		if( this.counter.getTotalProbes() == 0 )
			sb.append("Average number of probes per word check: " + 0 + "\n");
		else
			sb.append("Average number of probes per word check: " + (double)( this.input.size() / this.counter.getTotalProbes() ) + "\n");
		
		if( this.counter.getTotalLookUps() == 0 )
			sb.append("Average number of probes per lookup: " + 0 + "\n");
		else
			sb.append("Average number of probes per lookup: " + (double)(this.counter.getTotalProbes() / this.counter.getTotalLookUps()) + "\n");
		
		return sb.toString();
	}
}
