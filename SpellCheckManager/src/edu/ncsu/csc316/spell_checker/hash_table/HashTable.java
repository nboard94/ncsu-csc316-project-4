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

	/**
	 * Constructs a HashTable. Initialized all entries to null.
	 * 
	 * @param dictionary
	 *            The list of words in the dictionary, add to the HashTable.
	 * @param input
	 *            The list of words in the input file, convert to array of Word.
	 */
	public HashTable(ArrayBasedList<String> dictionary) {

		table = new Word[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null;
		}

		for (int i = 0; i < dictionary.size(); i++ ) {
			
			this.insert(dictionary.lookUp(i));
		}
	}

	/**
	 * Adds a word to the hash table.
	 * 
	 * @param value
	 *            The value of the word to add.
	 */
	public void insert(String value) {

		Word newWord = new Word(value);
		int hash = this.getHashFromKey(newWord.hashCode());

		if (table[hash] == null)

			table[hash] = newWord;
		else {

			Word entry = table[hash];

			while (entry.getNext() != null && entry.hashCode() != newWord.hashCode())
				entry = entry.getNext();

			if (entry.hashCode() == newWord.hashCode())
				entry.setWord(value);
			else
				entry.setNext(newWord);
		}
	}

	/**
	 * Looks up a Word in the hash table.
	 * 
	 * @param key
	 *            the hashcode of the Word to lookup.
	 * @return the found word.
	 */
	public String lookUp(int key) {

		int hash = this.getHashFromKey(key);

		if (table[hash] == null)

			return null;
		else {

			Word entry = table[hash];

			while (entry != null && entry.hashCode() != hash)
				entry = entry.getNext();

			if (entry == null)
				return null;
			else
				return entry.getWord();
		}

	}

	/**
	 * The Hashing function used in the table. Currently uses division hashing.
	 * TODO change to MAD or Golden Ratio if needed.
	 * 
	 * @param key
	 *            The key to hash with.
	 * @return The hashcode for the key.
	 */
	private int getHashFromKey(int key) {

		return (key % TABLE_SIZE);
	}
}
