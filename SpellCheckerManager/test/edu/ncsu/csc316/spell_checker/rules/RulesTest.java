package edu.ncsu.csc316.spell_checker.rules;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests all the rule transformations that can be applied.
 * 
 * @author Nicholas Board (ndboard)
 */
public class RulesTest {

	/** Rules object used to access rule methods. */
	Rules r = new Rules();

	/**
	 * Tests CapitalizationRule.
	 */
	@Test
	public void testCapitalizationRule() {

		assertEquals("the", r.capitalizationRule("the"));

		assertEquals("the", r.capitalizationRule("The"));
	}

	/**
	 * Tests PossessionRule.
	 */
	@Test
	public void testPossessionRule() {

		assertEquals("cook", r.possessionRule("cook"));

		assertEquals("cook", r.possessionRule("cook's"));
	}

	/**
	 * Tests PluralityRule1.
	 */
	@Test
	public void testPluralityRule1() {

		assertEquals("cake", r.pluralityRule1("cake"));

		assertEquals("cake", r.pluralityRule1("cakes"));
	}

	/**
	 * Tests PluralityRule2.
	 */
	@Test
	public void testPluralityRule2() {

		assertEquals("dish", r.pluralityRule2("dish"));

		assertEquals("dish", r.pluralityRule2("dishes"));
	}

	/**
	 * Tests PastTenseRule1.
	 */
	@Test
	public void testPastTenseRule1() {

		assertEquals("bake", r.pastTenseRule1("bake"));

		assertEquals("bake", r.pastTenseRule1("baked"));
	}

	/**
	 * Tests PastTenseRule2.
	 */
	@Test
	public void testPastTenseRule2() {

		assertEquals("cook", r.pastTenseRule2("cook"));

		assertEquals("cook", r.pastTenseRule2("cooked"));
	}

	/**
	 * Tests OccupationRule1.
	 */
	@Test
	public void testOccupationRule1() {

		assertEquals("bake", r.occupationRule1("bake"));

		assertEquals("bake", r.occupationRule1("baker"));
	}

	/**
	 * Tests OccupationRule2.
	 */
	@Test
	public void testOccupationRule2() {

		assertEquals("cook", r.occupationRule2("cook"));

		assertEquals("cook", r.occupationRule2("cooker"));
	}

	/**
	 * Tests GerundRule1.
	 */
	@Test
	public void testGerundRule1() {

		assertEquals("cook", r.gerundRule1("cook"));

		assertEquals("cook", r.gerundRule1("cooking"));
	}

	/**
	 * Tests GerundRule2.
	 */
	@Test
	public void testGerundRule2() {

		assertEquals("bake", r.gerundRule2("bake"));

		assertEquals("bake", r.gerundRule2("baking"));
	}

	/**
	 * Tests AdverbRule.
	 */
	@Test
	public void testAdverbRule() {

		assertEquals("delicious", r.adverbRule("delicious"));

		assertEquals("delicious", r.adverbRule("deliciously"));
	}
}
