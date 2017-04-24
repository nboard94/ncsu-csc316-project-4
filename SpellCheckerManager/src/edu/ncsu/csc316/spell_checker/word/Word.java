package edu.ncsu.csc316.spell_checker.word;

/**
 * A word object contains a word string and has a custome hashCode() method.
 * 
 * @author Nicholas Board (ndboard)
 */
public class Word {

	/** The word string. */
	private String word;

	/** The next word in the linked structure. */
	private Word next;

	/**
	 * Constructs a Word object.
	 * 
	 * @param word
	 *            The word string to set.
	 */
	public Word(String word) {

		this.word = word;
		this.next = null;
	}

	/**
	 * Gets the string in a Word.
	 * 
	 * @return The Word's string.
	 */
	public String getWord() {

		return this.word;
	}

	/**
	 * Sets the word.
	 * 
	 * @param word
	 *            to set.
	 */
	public void setWord(String word) {

		this.word = word;
	}

	/**
	 * Gets the Word's next Word.
	 * 
	 * @return The Word's next Word.
	 */
	public Word getNext() {

		return this.next;
	}

	/**
	 * Sets the next word.
	 * 
	 * @param next
	 *            The next word to set.
	 */
	public void setNext(Word next) {

		this.next = next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		return this.word.hashCode();
	}
}
