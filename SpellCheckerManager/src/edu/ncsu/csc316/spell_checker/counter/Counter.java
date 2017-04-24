package edu.ncsu.csc316.spell_checker.counter;

import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;

/**
 * The Counter keeps track of statistics such as number of probes and lookups.
 * 
 * @author Nicholas Board (ndboard)
 */
public class Counter {

	/** The number of words in the dictionary. */
	private static int dictionaryCount;

	/** The number of words in the input file. */
	private static int inputCount;

	/** The number of words that are misspelled. */
	private static int misspelled;

	/** The list of words that are misspelled. */
	private static ArrayBasedList<String> misspelledWords;

	/** The number of total probes. */
	private static int totalProbes;

	/** The number of total lookUps. */
	private static int totalLookUps;

	/**
	 * Constructs a Counter object, sets all fields to zero.
	 */
	public Counter() {

		Counter.dictionaryCount = 0;
		Counter.inputCount = 0;
		Counter.misspelled = 0;
		Counter.misspelledWords = new ArrayBasedList<String>();
		Counter.totalProbes = 0;
		Counter.totalLookUps = 0;
	}

	/**
	 * Sets all fields to zero again.
	 */
	public void resetCounter() {

		Counter.dictionaryCount = 0;
		Counter.inputCount = 0;
		Counter.misspelled = 0;
		Counter.misspelledWords = new ArrayBasedList<String>();
		Counter.totalProbes = 0;
		Counter.totalLookUps = 0;
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
	 */
	public void incrementDictionaryCount() {
		Counter.dictionaryCount++;
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
	 */
	public void incrementInputCount() {
		Counter.inputCount++;
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
	 */
	public void incrementMisspelled() {
		Counter.misspelled++;
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
	 */
	public void addMisspelledWord(String misspelledWord) {
		Counter.misspelledWords.insert(misspelledWord);
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
	 */
	public void incrementTotalProbes() {
		Counter.totalProbes++;
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
	 */
	public void incrementTotalLookUps() {
		Counter.totalLookUps++;
	}

	/**
	 * Gets the avgProbesPerWord.
	 * 
	 * @return the avgProbesPerWord
	 */
	public int getAvgProbesPerWord() {

		if (Counter.inputCount == 0)
			return 0;

		return Counter.totalProbes / Counter.inputCount;
	}

	/**
	 * Gets the avgProbesPerLookUp.
	 * 
	 * @return the avgProbesPerLookUp
	 */
	public int getAvgProbesPerLookUp() {

		if (Counter.inputCount == 0)
			return 0;

		return Counter.totalProbes / Counter.totalLookUps;
	}
}
