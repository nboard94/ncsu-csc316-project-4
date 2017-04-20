package edu.ncsu.csc316.spell_checker.rules;

/**
 * @author Nicholas Board (ndboard)
 * These transfomations are applied to words.
 */
public class Rules {

	/**
	 * If the first letter of a word is capitalized, convert
	 * the first letter to lowercase.
	 * The > the
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String CapitalizationRule(String word) {

		return Character.toLowerCase(word.charAt(0)) + word.substring(0, word.length());
	}
	
	/**
	 * If the word ends in 's, drop the 's.
	 * cook's > cook
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String PossessionRule(String word) {

		if( word.substring(word.length() - 2, word.length()).equals("'s"))
			return word.substring(0, word.length() - 2 );
		
		return word;
	}
	
	/**
	 * If the word ends in s, drop the s.
	 * cakes > cake
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String PluralityRule1(String word) {

		return null;
	}
	
	/**
	 * If the word ends in es, drop the es.
	 * dishes > dish
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String PluralityRule2(String word) {

		return null;
	}
	
	/**
	 * If the word ends in d, drop the d.
	 * baked > bake
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String PastTenseRule1(String word) {

		return null;
	}
	
	/**
	 * If the word ends in ed, drop the ed.
	 * cooked > cook
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String PastTenseRule2(String word) {

		return null;
	}
	
	/**
	 * If the word ends in r, drop the r.
	 * baker > bake
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String OccupationRule1(String word) {

		return null;
	}
	
	/**
	 * If the word ends in er, drop the er.
	 * cooker > cook
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String OccupationRule2(String word) {

		return null;
	}
	
	/**
	 * If the word ends in ing, drop the ing.
	 * cooking > cook
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String GerundRule1(String word) {

		return null;
	}
	
	/**
	 * If the word ends in ing, drop the in, add an e.
	 * baking > bake
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String GerundRule2(String word) {

		return null;
	}
	
	/**
	 * If the word ends in ly, drop the ly.
	 * deliciously, delicious
	 * @param word The word to change.
	 * @return The transformed word.
	 */
	public String AdverbRule(String word) {

		return null;
	}
}
