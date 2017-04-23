package edu.ncsu.csc316.spell_checker.hash_table;

import edu.ncsu.csc316.spell_checker.counter.Counter;
import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;
import edu.ncsu.csc316.spell_checker.word.Word;

/**
 * @author Nicholas Board (ndboard) The HashTable used in the
 *         SpellCheckerManager.
 */
public class HashTable {

	/** Size to initialize the HashTable's array to. */
	private final static int TABLE_SIZE = 1000000;

	/** The HashTable array. */
	private Word[] table;
	
	/** The HashTable size. */
	private int size;
	
	/** The Counter to keep track of probes. */
	private Counter counter = new Counter();

	/**
	 * Constructs a HashTable.
	 */
	public HashTable() {

		table = new Word[TABLE_SIZE];
		size = 0;
	}
	
	public void buildHashTable(ArrayBasedList<String> dictionary) {
		
		for( int i= 0; i < dictionary.size(); i++ ) {
			
			this.insert(dictionary.lookUp(i));
			this.counter.incrementDictionaryCount();
		}
	}

	//TODO Implement this
	public void insert(String value) {

		Word newWord = new Word(value);
		int hash = this.getHashFromKey(newWord.hashCode());
		
		if(table[hash] == null)
			table[hash] = newWord;
		else {
			
			Word entry = table[hash];
			
			while(entry.getNext() != null)
				entry = entry.getNext();
			
			entry.setNext(newWord);
		}
		
		this.size++;
	}

	//TODO Implement this
	public String lookUp(String word) {
		
		this.counter.incrementTotalLookUps();
		int hash = this.getHashFromKey(word.hashCode());
		
		this.counter.incrementTotalProbes();
		if(table[hash] == null)
			return null;
		else {
			
			Word entry = table[hash];
			
			while(entry != null && entry.getWord().hashCode() != word.hashCode()) {
				
				this.counter.incrementTotalProbes();
				entry = entry.getNext();
			}
				
			if(entry.getNext() == null && entry.getWord().hashCode() != word.hashCode())
				return null;
			else
				return entry.getWord();
			
		}
	}

	/**
	 * Tells the size of the HashTable.
	 * @return The size of the table.
	 */
	public int size() {
		
		return this.size;
	}
	
	/**
	 * Gets the counter used in this HashTable.
	 * @return The HashTable's counter.
	 */
	public Counter getCount() {
		
		return this.counter;
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

		int hash = ( key % TABLE_SIZE);
		
		if( hash < 0)
			hash *= -1;
			
		return hash;
	}
}
