/*
	Class: TestDNAReader
	Author: Preston Stosur-Bassett
	Date: Sept 19 2014
*/

import java.util.ArrayList;

/**
	<code>TestDNAReader</code> will test the input of text files containing DNA snippets during development of and Indexing Substrings Program.

	@author Preston Stosur-Bassett
	@course CS210 (Data Structures)
	@date 19.09.14 (dd.mm.yy)
	@assignment Indexing Substrings
*/

public class TestDNAReader {
	public static void main(String[] args) {
		//Turn on debugging through the provided Debugging code
		Debug.turnOn();

		//Create a validater object that will check to make sure the input is valid. 
		ValidatedInputReader validateInput = (ValidatedInputReader) new ValidatedInputReader();
		String filename = new String(validateInput.getString("Please provide the name of the file you would like to open.", "TestData.txt"));

		//Create a reader object that will read the data from the file the user inputed
		DNADataReader dataReader = (DNADataReader) new DNADataReader(filename);
		ArrayList<DNASequence> sequences;

		//Write out the data from the text file into the console.
		sequences = dataReader.readData();

		//Test the Location class
		Location testLoc = new Location(0, 10);
		System.out.println("Testing the Location Class: ");
		System.out.println(testLoc);
		System.out.println("");

		//Test the SubstringLocs Class
		SubstringLocs substringOne = new SubstringLocs("First Sequence", testLoc);
		Location newLoc = new Location(3, 0);
		substringOne.addLocation(newLoc);
		System.out.println("Testing the SubstringsLoc Class: ");
		System.out.println(substringOne);
	}
}