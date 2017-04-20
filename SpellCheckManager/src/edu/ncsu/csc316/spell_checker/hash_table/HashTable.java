package edu.ncsu.csc316.spell_checker.hash_table;

import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;
import edu.ncsu.csc316.spell_checker.word.Word;

/**
 * @author Nicholas Board (ndboard) The HashTable used in the
 *         SpellCheckerManager.
 */
public class HashTable {

	/** Size to initialize the HashTable's array to. */
	private final static int TABLE_SIZE = 128;

	/** The HashTable array. */
	private Word[] table;

	/** The list of words to check. */
	private ArrayBasedList<Word> input = new ArrayBasedList<Word>();

	/**
	 * Constructs a HashTable. Initialized all entries to null.
	 * 
	 * @param dictionary
	 *            The list of words in the dictionary, add to the HashTable.
	 * @param input
	 *            The list of words in the input file, convert to array of Word.
	 */
	public HashTable(ArrayBasedList<String> dictionary, ArrayBasedList<String> input) {

		table = new Word[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null;
		}

		for (int i = 0; i < input.size(); i++) {

			this.input.insert(new Word(input.lookUp(i)));
		}
	}

	public Word lookUp(int key) {

		return null;
	}

	public void insert(int key) {

	}

	public Word delete(int key) {

		return null;
	}
}
