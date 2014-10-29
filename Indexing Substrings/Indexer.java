/*
	Author: Preston Stosur-Bassett
	Course: CS210 (Data Structures)
	Class: Indexer
	Date: Sept 24 2014
	Assignment: Indexing Substrings
	Description: Indexer will obtain, store, organize, and display DNA Sequences from a '.txt' test file provided by the user.
*/

/**
	<code>Indexer</code> will obtain, store, organize, and display DNA Sequences from a <code>.txt</code> text file provided by the user.

	@author Preston Stosur-Bassett
	@course CS210 (Data Structures)
	@date 24.9.14 (dd.mm.yy)
	@assignment Indexing Substrings
*/

import java.util.ArrayList;

public class Indexer {
	private ArrayList<SubstringLocs> substringsAndLocs; //An ArrayList of Sequence Substrings and their correcsponding locations
	private String filename; //The Read-in file name
	private int substringLength; //The length of the substring to breka the sequences into
	private DNADataReader dataReader; //The data reader object that will read-in data from text file
	private ArrayList<DNASequence> sequences; //a list of DNA sequences to go through and break into sub-sequences

	/**
		<code>Indexer</code> constructor will validate the user's selection of sub-sequence length and read in data file. It will also initalize ArrayLists to store sequence information in.
	*/
	public Indexer() {
		//Create a validater object that will check to make sure the filename and sequence count input from the user is valid.
		ValidatedInputReader validateInput = (ValidatedInputReader) new ValidatedInputReader();
		filename = new String(validateInput.getString("Please provide the name of the file you would like to open.", "DNAData.txt"));
		substringLength = validateInput.getInteger("Please provide substring length you would like to use.", 2, 60, 4, "The substring length is the lenght of the DNA sequence you would like to index.");

		//Initialize a reader object that will read the data from the file the user selected. 
		dataReader = new DNADataReader(filename);
		
		//Store the data from the file the user selected into an array list of dna sequences.
		sequences = dataReader.readData();

		substringsAndLocs = new ArrayList<SubstringLocs>(600); //60 characters per in average DNA sequence, times an average of 10 DNA sequences in a DNA Data file, therefore 600 empty spots to store data in the ArrayList
	}

	/**
		<code>checkExisting</code> will scan through the <code>substringsAndLocs</code> ArrayList and check if a given sequence has already been added. 

		@param String subSequence 	DNA sub-sequence to check if already exists in the <code>substringsAndLocs</code> ArrayList
		@return boolean 	return true if the sequence passed as an argument exists, returns false otherwise
	*/
	private boolean checkExisting(String subSequence) {
		if(substringsAndLocs.size() != 0) {
			for(int i = 0; i < substringsAndLocs.size(); i++) {
				if(substringsAndLocs.get(i).getSequenceName().equals(subSequence)) {
					return true;
				}
			}
		}
		
		return false;
	} 

	/**
		<code>findSubstringsAndLocsIndex</code> will scan through the <code>substringsAndLocs</code> ArrayList and return the index of a given DNA sequence. If no sequence exists, returns -1

		@param String sequenceToFind 	The DNA sub-sequence to search for the index of in the <code>substringsAndLocs</code> ArrayList
		@return int 	return the index of the DNA sub-sequence, if it non exists, returns -1
	*/
	private int findSubstringsAndLocsIndex(String sequenceToFind) {
		for(int i = 0; i < substringsAndLocs.size(); i++) {
			if(substringsAndLocs.get(i).getSequenceName().equals(sequenceToFind)) {
				return i;
			}
		}

		return -1;
	}

	/**
		<code>runLine</code> will run through a line of DNA sequence passed to it and scan for all the sub-sequence in it. 

		@param String currentSequence	The current DNA sequence to scan through for sub-sequences
		@param int lineNumber	The line number of the <code>currentSequence</code> String
	*/
	private void runLine(String currentSequence, int lineNumber) {
		int startIndex = 0; //The start index of the substring
		int endIndex = substringLength; //The end index of the substring
		while(endIndex <= currentSequence.length()) {
			String currentSubstring = currentSequence.substring(startIndex, endIndex); //The current substring of the current sequence
			Location currentLocation = new Location(lineNumber, startIndex); //The current location for the current substring

			if(checkExisting(currentSubstring) == false) {
				SubstringLocs currentStringAndLocation = new SubstringLocs(currentSubstring, currentLocation); //the current substring and location to be added to the substringsAndLocs ArrayList
				substringsAndLocs.add(currentStringAndLocation);
			}
			else {
				int elementIndexToUpdate = findSubstringsAndLocsIndex(currentSubstring); //the index of the element to add the current location to
				if(elementIndexToUpdate == -1) {
					System.out.println("There was an issue looking up the substring sequence you request. Skipping, moving on...");
				}
				else {
					substringsAndLocs.get(elementIndexToUpdate).addLocation(currentLocation);
				}
			}

			startIndex = startIndex + 1;
			endIndex = endIndex + 1;
		}
	}

	/**
		<code>run</code> will iterate through each one of the DNA sequences stored in the <code>sequences</code> ArrayList and pass them to runLine.
	*/
	public void run() {
		for(int i = 0; i < sequences.size(); i++) {
			runLine(sequences.get(i).getSequence(), i);
		}
	}

	/**
		<code>printResults</code> will print all the sub-sequences and their respective locations out to the console
	*/
	public void printResults() {
		for(int i = 0; i < substringsAndLocs.size(); i++) {
			if(substringsAndLocs.get(i) != null) {
				System.out.println(substringsAndLocs.get(i).toString());
			}
		}
	}
}