package edu.ncsu.csc316.spell_checker.manager;

import edu.ncsu.csc316.spell_checker.io.TextFileReader;
import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;

/**
 * @author Nicholas Board (ndboard) The engine of the SpellCheckManager program.
 */
public class SpellCheckerManager {

	/** Contains all words in the dictionary. */
	private ArrayBasedList<String> dictionary;

	/** Contains all words in the input file. */
	private ArrayBasedList<String> input;

	/** TextFileReader to scan both the dictionary and input file. */
	private TextFileReader fileReader;

	/**
	 * Constructs a new Spell Checker with the given dictionary
	 * 
	 * @param pathToDictionary
	 *            the path to the dictionary
	 */
	public SpellCheckerManager(String pathToDictionary) {
		fileReader = new TextFileReader(pathToDictionary);
		dictionary = fileReader.getWords();
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
		fileReader = new TextFileReader(pathToFile);
		input = fileReader.getWords();

		return pathToFile;
	}
}
