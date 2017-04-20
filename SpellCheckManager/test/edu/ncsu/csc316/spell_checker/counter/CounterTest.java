package edu.ncsu.csc316.spell_checker.counter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Nicholas Board (ndboard)
 *
 * Tests the Counter class.
 */
public class CounterTest {

	@Test
	public void counterTest() {
		
		Counter counter = new Counter();
		assertEquals(0, counter.getDictionaryCount());
		assertEquals(0, counter.getInputCount());
		assertEquals(0, counter.getMisspelled());
		assertEquals(0, counter.getMisspelledWords().size());
		assertEquals(0, counter.getTotalProbes());
		assertEquals(0, counter.getTotalLookUps());
		assertEquals(0, counter.getAvgProbesPerWord());
		assertEquals(0, counter.getAvgProbesPerLookUp());
		
		counter.setDictionaryCount(200);
		assertEquals(200, counter.getDictionaryCount());
		
		counter.setInputCount(50);
		assertEquals(50, counter.getInputCount());
		
		counter.setMisspelled(151);
		assertEquals(151, counter.getMisspelled());
		
		counter.addMisspelledWord("one");
		counter.addMisspelledWord("two");
		counter.addMisspelledWord("three");
		assertEquals(3, counter.getMisspelledWords().size());
		
		counter.setTotalProbes(100);
		assertEquals(100, counter.getTotalProbes());
		
		counter.setTotalLookUps(20);
		assertEquals(20, counter.getTotalLookUps());
		
		assertEquals(2, counter.getAvgProbesPerWord());
		assertEquals(5, counter.getAvgProbesPerLookUp());
		
		counter.resetCounter();
		assertEquals(0, counter.getDictionaryCount());
		assertEquals(0, counter.getInputCount());
		assertEquals(0, counter.getMisspelled());
		assertEquals(0, counter.getMisspelledWords().size());
		assertEquals(0, counter.getTotalProbes());
		assertEquals(0, counter.getTotalLookUps());
		assertEquals(0, counter.getAvgProbesPerWord());
		assertEquals(0, counter.getAvgProbesPerLookUp());
	}
}
