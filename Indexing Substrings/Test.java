/*
	Author: Preston Stosur-Bassett
	Course: CS210 (Data Structures)
	Class: Test
	Date: Sept 28 2014
	Assignment: Indexing Substrings
	Description: This class will test the functionality of all the classes in this project working together.
*/

/**
	<code>Test</code> will test the functionality of all the classes in the <code>Indexing Substrings</code> project.

	@author Preston Stosur-Bassett
	@course CS210 (Data Strcutures)
	@date 28.09.14 (dd.mm.yy)
	@assignment Indexing Substrings
*/

public class Test {
	public static void main(String[] args) {
		Indexer indexSequences = new Indexer(); //Create a new Indexer object to run through all the sequences of a given data file

		indexSequences.run(); //run through all the sequences and sub-sequences of a given data file
		indexSequences.printResults(); //print the resulting sub-strings and location determined by the run method called
	}
}