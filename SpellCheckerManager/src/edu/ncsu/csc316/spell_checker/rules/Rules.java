package edu.ncsu.csc316.spell_checker.rules;

/**
 * These transfomations are applied to words.
 * 
 * @author Nicholas Board (ndboard)
 */
public class Rules {

	/**
	 * Construct a Rules object so we can access the rule methods.
	 */
	public Rules() {

		// Intentionally left empty.
	}

	/**
	 * If the first letter of a word is capitalized, convert the first letter to
	 * lowercase. The > the
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String capitalizationRule(String word) {

		if (Character.isUpperCase(word.charAt(0)))
			return Character.toLowerCase(word.charAt(0)) + word.substring(1, word.length());

		return word;
	}

	/**
	 * If the word ends in 's, drop the 's. cook's > cook
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String possessionRule(String word) {

		if (word.substring(word.length() - 2, word.length()).equals("'s"))
			return word.substring(0, word.length() - 2);

		return word;
	}

	/**
	 * If the word ends in s, drop the s. cakes > cake
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String pluralityRule1(String word) {

		if (word.charAt(word.length() - 1) == 's')
			return word.substring(0, word.length() - 1);

		return word;
	}

	/**
	 * If the word ends in es, drop the es. dishes > dish
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String pluralityRule2(String word) {

		if (word.substring(word.length() - 2).equals("es"))
			return word.substring(0, word.length() - 2);

		return word;
	}

	/**
	 * If the word ends in d, drop the d. baked > bake
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String pastTenseRule1(String word) {

		if (word.charAt(word.length() - 1) == 'd')
			return word.substring(0, word.length() - 1);

		return word;
	}

	/**
	 * If the word ends in ed, drop the ed. cooked > cook
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String pastTenseRule2(String word) {

		if (word.substring(word.length() - 2).equals("ed"))
			return word.substring(0, word.length() - 2);

		return word;
	}

	/**
	 * If the word ends in r, drop the r. baker > bake
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String occupationRule1(String word) {

		if (word.charAt(word.length() - 1) == 'r')
			return word.substring(0, word.length() - 1);

		return word;
	}

	/**
	 * If the word ends in er, drop the er. cooker > cook
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String occupationRule2(String word) {

		if (word.substring(word.length() - 2).equals("er"))
			return word.substring(0, word.length() - 2);

		return word;
	}

	/**
	 * If the word ends in ing, drop the ing. cooking > cook
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String gerundRule1(String word) {

		if (word.length() > 3 && word.substring(word.length() - 3).equals("ing"))
			return word.substring(0, word.length() - 3);

		return word;
	}

	/**
	 * If the word ends in ing, drop the ing, add an e. baking > bake
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String gerundRule2(String word) {

		if (word.length() > 3 && word.substring(word.length() - 3).equals("ing"))
			return word.substring(0, word.length() - 3) + 'e';

		return word;
	}

	/**
	 * If the word ends in ly, drop the ly. deliciously, delicious
	 * 
	 * @param word
	 *            The word to change.
	 * @return The transformed word.
	 */
	public String adverbRule(String word) {

		if (word.substring(word.length() - 2).equals("ly"))
			return word.substring(0, word.length() - 2);

		return word;
	}
}
