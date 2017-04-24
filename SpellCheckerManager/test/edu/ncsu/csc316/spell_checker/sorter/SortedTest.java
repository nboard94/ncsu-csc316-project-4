package edu.ncsu.csc316.spell_checker.sorter;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;

/**
 * Tests the Sorted class.
 * 
 * @author Nicholas Board (ndboard)
 */
public class SortedTest {

	/**
	 * Tests the Sorted class.
	 */
	@Test
	public void testSorted() {

		ArrayBasedList<String> list = new ArrayBasedList<String>();
		list.insert("dog");
		list.insert("turtle");
		list.insert("zebra");
		list.insert("cat");
		list.insert("ant");

		Sorted s = new Sorted();

		list = s.quicksort(list, 0, list.size() - 1);
		assertEquals("ant", list.lookUp(0));
		assertEquals("cat", list.lookUp(1));
		assertEquals("dog", list.lookUp(2));
		assertEquals("turtle", list.lookUp(3));
		assertEquals("zebra", list.lookUp(4));
	}

}
