package edu.ncsu.csc316.spell_checker.word;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Word class.
 * 
 * @author Nicholas Board (ndboard)
 */
public class WordTest {

	/**
	 * Tests the construction and functionality of a word.
	 */
	@Test
	public void wordTest() {

		Word word1 = new Word("one");
		assertEquals("one", word1.getWord());

		Word word2 = new Word("two");
		assertEquals("two", word2.getWord());

		Word word3 = new Word("three");
		assertEquals("three", word3.getWord());

		word3.setWord("one");
		assertEquals("one", word3.getWord());

		assertNull(word1.getNext());
		assertNull(word2.getNext());
		assertNull(word3.getNext());

		word1.setNext(word2);
		word2.setNext(word3);
		assertEquals(word2, word1.getNext());
		assertEquals(word3, word2.getNext());

		assertNotEquals(word1.hashCode(), word2.hashCode());
		assertNotEquals(word3.hashCode(), word2.hashCode());
		assertEquals(word1.hashCode(), word3.hashCode());
	}
}
