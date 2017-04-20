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
	 * Sets the dictionaryCount.
	 * 
	 * @param dictionaryCount
	 *            the dictionaryCount to set
	 */
	public void setDictionaryCount(int dictionaryCount) {
		this.dictionaryCount = dictionaryCount;
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
	 * Sets the inputCount.
	 * 
	 * @param inputCount
	 *            the inputCount to set
	 */
	public void setInputCount(int inputCount) {
		this.inputCount = inputCount;
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
	 * Sets the misspelled.
	 * 
	 * @param misspelled
	 *            the misspelled to set
	 */
	public void setMisspelled(int misspelled) {
		this.misspelled = misspelled;
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
	 * Sets the totalProbes.
	 * 
	 * @param totalProbes
	 *            the totalProbes to set
	 */
	public void setTotalProbes(int totalProbes) {
		this.totalProbes = totalProbes;
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
	 * Sets the totalLookUps.
	 * 
	 * @param totalLookUps
	 *            the totalLookUps to set
	 */
	public void setTotalLookUps(int totalLookUps) {
		this.totalLookUps = totalLookUps;
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
