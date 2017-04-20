package edu.ncsu.csc316.spell_checker.hash_table;

import edu.ncsu.csc316.spell_checker.word.Word;

public class HashTable {
	
	/** Size to initialize the HashTable's array to.*/
	private final static int TABLE_SIZE = 128;
	
	/** The HashTable array. */
	private Word[] table;
	
	/**
	 * Constructs a HashTable.
	 * Initialized all entries to null.
	 */
	public HashTable() {
		
		table = new Word[TABLE_SIZE];
		for( int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null;
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
