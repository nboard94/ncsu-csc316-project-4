package edu.ncsu.csc316.spell_checker.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.spell_checker.list.ArrayBasedList;

/**
 * @author Nicholas Board (ndboard)
 * Handles the input of a dictionary or input file.
 */
public class TextFileReader {

	/** The list of scanned words. */
	private ArrayBasedList<String> words = new ArrayBasedList<String>();
	
	/** Scanner used to read the input file. */
	private Scanner fileScan;
	
	/**
	 * The TextFileReader object takes an input file and builds
	 * an ArrayBasedList containing the scanned words.
	 * @param filepath The path of the file to read in.
	 */
	public TextFileReader(String filepath) {
		
		try {
			
			fileScan = new Scanner( new FileInputStream(filepath), "UTF8");
		} catch (FileNotFoundException e) {
			
			//This block intentionally left empty.
			//The UI tests if a file does not exist, should never
			//actually catch FileNotFoundException.
		}
		
		while(fileScan.hasNext()) {
			
			words.insert(fileScan.next());
		}
		
		fileScan.close();
	}
	
	/**
	 * Gets the list of words.
	 * @return The list of words.
	 */
	public ArrayBasedList<String> getWords() {
		
		return this.words;
	}
}
