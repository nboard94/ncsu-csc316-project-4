package edu.ncsu.csc316.spell_checker.rules;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Nicholas Board (ndboard) Tests all the rule transformations that can
 *         be applied.
 */
public class RulesTest {

	/** Rules object used to access rule methods. */
	Rules r = new Rules();

	/**
	 * Tests CapitalizationRule.
	 */
	@Test
	public void testCapitalizationRule() {

		assertEquals("the", r.CapitalizationRule("the"));

		assertEquals("the", r.CapitalizationRule("The"));
	}

	/**
	 * Tests PossessionRule.
	 */
	@Test
	public void testPossessionRule() {

		assertEquals("cook", r.PossessionRule("cook"));

		assertEquals("cook", r.PossessionRule("cook's"));
	}

	/**
	 * Tests PluralityRule1.
	 */
	@Test
	public void testPluralityRule1() {

		assertEquals("cake", r.PluralityRule1("cake"));

		assertEquals("cake", r.PluralityRule1("cakes"));
	}

	/**
	 * Tests PluralityRule2.
	 */
	@Test
	public void testPluralityRule2() {

		assertEquals("dish", r.PluralityRule2("dish"));

		assertEquals("dish", r.PluralityRule2("dishes"));
	}

	/**
	 * Tests PastTenseRule1.
	 */
	@Test
	public void testPastTenseRule1() {

		assertEquals("bake", r.PastTenseRule1("bake"));

		assertEquals("bake", r.PastTenseRule1("baked"));
	}

	/**
	 * Tests PastTenseRule2.
	 */
	@Test
	public void testPastTenseRule2() {

		assertEquals("cook", r.PastTenseRule2("cook"));

		assertEquals("cook", r.PastTenseRule2("cooked"));
	}

	/**
	 * Tests OccupationRule1.
	 */
	@Test
	public void testOccupationRule1() {

		assertEquals("bake", r.OccupationRule1("bake"));

		assertEquals("bake", r.OccupationRule1("baker"));
	}

	/**
	 * Tests OccupationRule2.
	 */
	@Test
	public void testOccupationRule2() {

		assertEquals("cook", r.OccupationRule2("cook"));

		assertEquals("cook", r.OccupationRule2("cooker"));
	}

	/**
	 * Tests GerundRule1.
	 */
	@Test
	public void testGerundRule1() {

		assertEquals("cook", r.GerundRule1("cook"));

		assertEquals("cook", r.GerundRule1("cooking"));
	}

	/**
	 * Tests GerundRule2.
	 */
	@Test
	public void testGerundRule2() {

		assertEquals("bake", r.GerundRule2("bake"));

		assertEquals("bake", r.GerundRule2("baking"));
	}

	/**
	 * Tests AdverbRule.
	 */
	@Test
	public void testAdverbRule() {

		assertEquals("delicious", r.AdverbRule("delicious"));

		assertEquals("delicious", r.AdverbRule("deliciously"));
	}
}
