package edu.ncsu.csc316.spell_checker.counter;

import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;

/**
 * @author Nicholas Board (ndboard) The Counter keeps track of statistics such
 *         as number of probes and lookups.
 */
public class Counter {

	/** The number of words in the dictionary. */
	private int dictionaryCount;

	/** The number of words in the input file. */
	private int inputCount;

	/** The number of words that are misspelled. */
	private int misspelled;

	/** The list of words that are misspelled. */
	private ArrayBasedList<String> misspelledWords;

	/** The number of total probes. */
	private int totalProbes;

	/** The number of total lookUps. */
	private int totalLookUps;

	/**
	 * Constructs a Counter object, sets all fields to zero.
	 */
	public Counter() {

		this.dictionaryCount = 0;
		this.inputCount = 0;
		this.misspelled = 0;
		this.misspelledWords = new ArrayBasedList<String>();
		this.totalProbes = 0;
		this.totalLookUps = 0;
	}

	/**
	 * Sets all fields to zero again.
	 */
	public void resetCounter() {

		this.dictionaryCount = 0;
		this.inputCount = 0;
		this.misspelled = 0;
		this.misspelledWords = new ArrayBasedList<String>();
		this.totalProbes = 0;
		this.totalLookUps = 0;
	}

	/**
	 * Gets the dictionaryCount.
	 * 
	 * @return the dictionaryCount
	 */
	public int getDictionaryCount() {
		return dictionaryCount;
	}

	/**
	 * Increment the dictionaryCount.
	 * 
	 * @param dictionaryCount
	 *            the dictionaryCount to Increment
	 */
	public void incrementDictionaryCount() {
		this.dictionaryCount++;
	}

	/**
	 * Gets the inputCount.
	 * 
	 * @return the inputCount
	 */
	public int getInputCount() {
		return inputCount;
	}

	/**
	 * Increment the inputCount.
	 * 
	 * @param inputCount
	 *            the inputCount to increment
	 */
	public void incrementInputCount() {
		this.inputCount++;
	}

	/**
	 * Gets the misspelled.
	 * 
	 * @return the misspelled
	 */
	public int getMisspelled() {
		return misspelled;
	}

	/**
	 * Increment the misspelled.
	 * 
	 * @param misspelled
	 *            the misspelled to increment
	 */
	public void incrementMisspelled() {
		this.misspelled++;
	}

	/**
	 * Gets the misspelledWords.
	 * 
	 * @return the misspelledWords
	 */
	public ArrayBasedList<String> getMisspelledWords() {
		return misspelledWords;
	}

	/**
	 * Adds a misspelledWord.
	 * 
	 * @param misspelledWord
	 *            the misspelledWord to add
	 */
	public void addMisspelledWord(String misspelledWord) {
		this.misspelledWords.insert(misspelledWord);
	}

	/**
	 * Gets the totalProbes.
	 * 
	 * @return the totalProbes
	 */
	public int getTotalProbes() {
		return totalProbes;
	}

	/**
	 * Increment the totalProbes.
	 * 
	 * @param totalProbes
	 *            the totalProbes to increment
	 */
	public void incrementTotalProbes() {
		this.totalProbes++;
	}

	/**
	 * Gets the totalLookUps.
	 * 
	 * @return the totalLookUps
	 */
	public int getTotalLookUps() {
		return totalLookUps;
	}

	/**
	 * Increment the totalLookUps.
	 * 
	 * @param totalLookUps
	 *            the totalLookUps to increment
	 */
	public void incrementTotalLookUps() {
		this.totalLookUps++;
	}

	/**
	 * Gets the avgProbesPerWord.
	 * 
	 * @return the avgProbesPerWord
	 */
	public int getAvgProbesPerWord() {
		
		if(this.inputCount == 0)
			return 0;
		
		return this.totalProbes / this.inputCount;
	}

	/**
	 * Gets the avgProbesPerLookUp.
	 * 
	 * @return the avgProbesPerLookUp
	 */
	public int getAvgProbesPerLookUp() {
		
		if(this.getInputCount() == 0)
			return 0;
		
		return this.totalProbes / this.totalLookUps;
	}
}
