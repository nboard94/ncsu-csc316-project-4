package edu.ncsu.csc316.spell_checker.ui;

import java.io.File;
import java.util.Scanner;

import edu.ncsu.csc316.spell_checker.manager.SpellCheckerManager;

/**
 * Controls the mechanisms that interfaces with the user.
 * 
 * @author Nicholas Board (ndboard)
 */
public class SpellCheckerUI {

	/**
	 * String that represents filepath for dictionary file. Set to test path by
	 * default.
	 */
	private static String dictionaryFile = "input/dictionary.txt";

	/**
	 * String that represents filepath for input file. Set to test path by
	 * default.
	 */
	private static String inputFile = "input/input.txt";

	/** Scanner used to read user input. */
	private static Scanner uiScan = new Scanner(System.in);

	/** The manager that handles the spell check functionality. */
	private static SpellCheckerManager manager;

	/** Used to check if a filepath is valid, or not. */
	private static File testFile;

	/**
	 * Where the SpellCheckManager begins execution. Loop continuously until the
	 * specified dictionary file exists. Then loop continuously allowing checks
	 * on different input files.
	 * 
	 * @param args
	 *            Contains command-line arguments, if there are any.
	 */
	public static void main(String[] args) {

		System.out.println("Enter \"quit\" at anytime to exit the program.");

		while (true) {

			System.out.print("Please specify dictionary file: ");
			dictionaryFile = uiScan.next();

			if (dictionaryFile.toLowerCase().equals("quit"))
				System.exit(0);

			testFile = new File(dictionaryFile);
			if (testFile.exists()) {

				manager = new SpellCheckerManager(dictionaryFile);
				while (true) {

					System.out.print("Please specify file to check: ");
					inputFile = uiScan.next();

					if (inputFile.toLowerCase().equals("quit"))
						System.exit(0);

					testFile = new File(inputFile);
					if (testFile.exists()) {

						System.out.println(manager.spellCheck(inputFile));
						System.out.println(manager.report());
					} else {

						System.out.println("Invalid input file, please enter a valid filepath.");
					}
				}

			} else {

				System.out.println("Invalid dictionary file, please enter a valid filepath.");
			}
		}
	}
}
