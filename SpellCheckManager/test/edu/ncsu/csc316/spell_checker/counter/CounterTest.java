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
		
		counter.incrementDictionaryCount();
		assertEquals(1, counter.getDictionaryCount());
		
		counter.incrementInputCount();
		assertEquals(1, counter.getInputCount());
		
		counter.incrementMisspelled();
		assertEquals(1, counter.getMisspelled());
		
		counter.addMisspelledWord("one");
		counter.addMisspelledWord("two");
		counter.addMisspelledWord("three");
		assertEquals(3, counter.getMisspelledWords().size());
		
		counter.incrementTotalProbes();
		assertEquals(1, counter.getTotalProbes());
		
		counter.incrementTotalLookUps();
		assertEquals(1, counter.getTotalLookUps());
		
		assertEquals(1, counter.getAvgProbesPerWord());
		assertEquals(1, counter.getAvgProbesPerLookUp());
		
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
