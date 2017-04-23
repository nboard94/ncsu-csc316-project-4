package edu.ncsu.csc316.spell_checker.io;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Nicholas Board (ndboard) Tests the TextFileReader class.
 */
public class TextFileReaderTest {

	/** TextFileReader object used for testing. */
	TextFileReader reader;

	/** The filepath of the test file. */
	String testFile = "input/dictionary.txt";

	/**
	 * Tests the construction and functionality of TextFileReader.
	 */
	@Test
	public void textFileReaderTest() {

		// Test construction
		reader = new TextFileReader(testFile);
		assertEquals(10, reader.getWords().size());

		// Test contents of reader's word list.
		assertEquals("the", reader.getWords().lookUp(0));
		assertEquals("quick", reader.getWords().lookUp(1));
		assertEquals("red", reader.getWords().lookUp(2));
		assertEquals("fox", reader.getWords().lookUp(3));
		assertEquals("jump", reader.getWords().lookUp(4));
		assertEquals("over", reader.getWords().lookUp(5));
		assertEquals("lazy", reader.getWords().lookUp(6));
		assertEquals("brown", reader.getWords().lookUp(7));
		assertEquals("dog", reader.getWords().lookUp(8));
		assertEquals("again", reader.getWords().lookUp(9));
	}
}
