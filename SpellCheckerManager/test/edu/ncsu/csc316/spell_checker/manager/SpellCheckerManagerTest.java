package edu.ncsu.csc316.spell_checker.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the SpellCheckerManager.
 * 
 * @author Nicholas Board (ndboard)
 */
public class SpellCheckerManagerTest {

	
	private String pathToD = "input/dictionary.txt";
	private String pathToI = "input/input.txt";
	private String misspelled = "ArrayBasedList[and, are, However, most, of, those]";
	
	/**
	 * Test the SpellCheckerManager.
	 */
	@Test
	public void testSpellCheckManager() {
		
		SpellCheckerManager manager = new SpellCheckerManager(pathToD);
		
		assertEquals(misspelled, manager.spellCheck(pathToI));
		
		manager.report();
	}
}
