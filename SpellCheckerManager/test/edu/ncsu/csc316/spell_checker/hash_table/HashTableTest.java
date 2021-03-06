package edu.ncsu.csc316.spell_checker.hash_table;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.spell_checker.counter.Counter;
import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;

/**
 * Test the HashTable class.
 * 
 * @author Nicholas Board (ndboard)
 */
public class HashTableTest {

	/**
	 * Tests the HashTable class.
	 */
	@Test
	public void testHashTable() {

		HashTable table = new HashTable();
		assertEquals(0, table.size());
		Counter count = table.getCount();
		assertEquals(count, table.getCount());

		ArrayBasedList<String> smallD = new ArrayBasedList<String>();
		smallD.insert("little");
		smallD.insert("brown");
		table.buildHashTable(smallD);
		assertEquals(2, table.size());

		table.insert("dog");
		assertEquals(3, table.size());

		assertEquals("little", table.lookUp("little"));
		assertEquals("brown", table.lookUp("brown"));
		assertEquals("dog", table.lookUp("dog"));

		assertNull(table.lookUp("big"));
		assertNull(table.lookUp("red"));
		assertNull(table.lookUp("Clifford"));
		
		table.insert("dog");
		table.insert("dog");
	}
}
