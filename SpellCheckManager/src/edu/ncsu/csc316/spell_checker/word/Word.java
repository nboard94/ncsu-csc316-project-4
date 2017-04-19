package edu.ncsu.csc316.spell_checker.word;

/**
 * @author Nicholas Board (ndboard)
 * A word object contains a word string and has a custome hashCode() method.
 */
public class Word {

	/** The word string. */
	private String word;
	
	/**
	 * Constructs a Word object.
	 * @param word The word string to set.
	 */
	public Word(String word) {
		
		this.word = word;
	}
	
	/**
	 * Gets the string in a Word.
	 * @return The Word's string.
	 */
	public String getWord() {
		
		return this.word;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		int hash = 7;
		for (int i = 0; i < word.length(); i++) {
		    hash = hash * 31 + word.charAt(i);
		}
		
		return hash;
	}
}
