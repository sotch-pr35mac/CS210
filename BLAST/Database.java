/*
* @author: Preston Stosur-Bassett
* @date: 25.11.14
* @class: Database
* @course: CS210
* @description:  This class contains the DNA sequence data, it contains the HashMap that holda all possible nn-letter words contained in this DNA data,
                  it has a method to find matches of substrings of a query sequence, a method to extend those matches, and possibly a method to display the matches.
*/

import java.util.*;

public class Database {
  private ArrayList<DNASequence> sequences; //a list of DNA Sequences.
  private Hashtable ht;
  private ArrayList<LocsList> locsList = new ArrayList<LocsList>(60);
  private int score;

  /*
  * <code>Database</code> will contrcut a database based off the data present in a file
  */
  public Database() {
    //Ask the user what the filename is of the file they want to use to build the database off of
    ValidatedInputReader validInput = new ValidatedInputReader();
    String filename = new String(validInput.getString("Please provide the name of the file you would like to use to build the database.", "DNAData.txt"));
    DNADataReader dataReader = new DNADataReader(filename, 10);

    score = 0;

    sequences = dataReader.readData();

    ht = new Hashtable(sequences.size());

    this.build();
  }

  /*
    <code>runLine</code> will run through a line of DNA sequence passed to it and scan for all the subsequences in it.

    @param String currentSequence The current DNA sequence to scan through for sub-sequences
    @param int lineNumber the line number of the <code>currentSequence</code> String
  */
  private void runLine(String currentSequence, int lineNumber) {
    int startIndex = 0; //The start index of the substring
    int endIndex = 10; //The end index of the substring
    while(endIndex <= currentSequence.length()) {
      String currentSubstring = currentSequence.substring(startIndex, endIndex); //The current substring of the current sequence
      Location currentLocation = new Location(lineNumber, startIndex); //The current location for the current substring

      if(ht.containsKey(currentSubstring) == false) {
        LocsList newLocList = new LocsList(currentLocation);
        ht.put(currentSubstring, newLocList);
      }
      else {
        LocsList locationToUpdate = (LocsList)ht.get(currentSubstring);
        locationToUpdate.addLocation(currentLocation);
      }

      startIndex++;
      endIndex++;
    }
  }

  /*
    <code>checkLeft</code> will check to ensure that it is safe to run the left of the subsequence for extentions

    @param int startIndex the index to start from
    @return boolean doLeft true if it is safe to proceed left, false otherwise
  */
  private boolean checkLeft(int startIndex) {
    boolean doLeft = false;
    if(startIndex > 0) {
      doLeft = true;
    }

    return doLeft;
  }

  /*
    <code>checkRight</code> will check to see if it is safe to proceed extending to the right of the sequence end index for matches

    @param int endIndex the end of the subsequence index
    @param String sequence the sequence to check it on
    @return boolean doRight returns true if it is safe to proceed to the right, returns false otherwise
  */
  private boolean checkRight(int endIndex, String sequence) {
    boolean doRight = false;
    if(sequence.substring(endIndex, endIndex+1) != "" || sequence.substring(endIndex, endIndex+1) != " ") {
      doRight = true;
    }

    return doRight;
  }

  /*
    <code>runLeft<code> will check to see if the characters to the left of this sequence (according to index) are matches to the full  sequence

    @param String currentSequence the full sequence passed as a query
    @param ArrayList<Location> currentListing the list of Location values for the full sequences stored in the database
    @param int startIndex the value to move left from in the full sequence
  */
  private void runLeft(String currentSequence, ArrayList<Location> currentListing, int startIndex) {
    if(startIndex > 0) {
      //If the start of the index is not the beginning of the string extend to the left
      for(int i = 0; i < currentListing.size(); i++) {
        int indexOfSequence = currentListing.get(i).getSequenceNumber();
        int indexOfSubSequence = currentListing.get(i).getSequenceIndex();
        String sequenceToRun = sequences.get(indexOfSequence);
        if(currentSequence.substring(startIndex - 1, startIndex) == sequenceToRun.substring(indexOfSubSequence - 1, indexOfSubSequence)) {
          score++;
          startIndex--;
          this.runLeft(currentSequence, currentListing, startIndex);
        }
        else {
          //There was a character mismatch, break the runLeft
          break;
        }
      }
    }
  }

  /*
    <code>search</code> will search the data base for the DNA sub-sequence of the sequence passed to it and will return an ArrayList<MatchElement>

    @param DNASequence the dna sequence to split into subsquences and search the databaes for that subsequence
    @return ArrayList<MatchElement> an array list of substrings that matched and their locations
  */
  public ArrayList<MatchElement> search(String currentSequence, int threshold) {
    ArrayList<MatchElement> foundElementArray = new ArrayList<MatchElement>();
    int startIndex = 0; // The start index of the substring
    int endIndex = 10; //The end index of the substring
    boolean validRunRight = true; //boolean to check if a character had been mismatched
    boolean validRunLeft = true; //boolean to check if a character had been mismatched
    while(endIndex <= currentSequence.length()) {
      String currentSubstring = currentSequence.substring(startIndex, endIndex); //The current substring of the current sequence

      if(ht.containsKey(currentSubstring) == true) {
        //The sequence was found!
        int score = 11; //The score is 11 because there was an 11-character substring match
        LocsList currentLocListObject = (LocsList)ht.get(currentSubstring);
        ArrayList<Location> currentListing = currentLocListObject.getLocationListing();
        /** Extend the sequence until a mismatch if found, score must be above threshold **/
        for(int i = 0; currentListing.size(); i++) {
          if(this.checkLeft() == true && validRunLeft == true) {
            int indexOfSequence = currentListing.get(i).getSequenceNumber();
            int indexOfSubSequence = currentListing.get(i).getSequenceIndex();
            String sequenceToRun = sequences.get(indexOfSequence);
            if(currentSequence.substring(startIndex - 1, startIndex) == sequenceToRun.substring(indexOfSubSequence - 1, indexOfSubSequence)) {
              score++;
              startIndex--;
              validRunLeft = false;
            }
          }
          if(this.checkRight() == true && validRunRight == true) {
            int indexOfSequence = currentListing.get(i).getSequenceNumber();
            int indexOfSubSequence = currentListing.get(i).getSequenceIndex();
            String sequenceToRun = sequence.get(indexOfSequence);
            if(currentSequence.substring(endIndex, endIndex + 1) == sequenceToRun.substring(indexOfSubSequence, indexOfSubSequence + 1)) {
              score++;
              endIndex++;
              validRunRight = false;
            }
          }
        }

        if(score >= threshold) {
          /** Record the current sequence and its locations, add it ot the array list */
          LocsList currentList = (LocsList)ht.get(currentSubstring);
          MatchElement matchedElement = new MatchElement(currentSubstring, currentList.getLocationListing(), score);
          if(foundElementArray.contains(matchedElement) == false) {
            //The sequence has not already been found, add it once to the array
            foundElementArray.add(matchedElement);
          }
        }
      }

      startIndex++;
      endIndex++;
    }

    return foundElementArray;
  }

  /*
    <code>getFullSequence</code> will return the full sequence from the provided index value

    @param int index of the sequence to return
    @return DNASequence the sequence of the given index value, if not sequence with that value is found, return -1
  */
  public DNASequence getFullSequence(int index) {
    if(index > sequences.size() - 1 || index < 0) {
      System.out.println("The sequence you requested was out of bounds.");
      return null;
    }

    return sequences.get(index);
  }

  /*
    <code>build</code> will iterate through the all the sequences and then run each line and separate it into different 11-character substrings
  */
  private void build() {
    for(int i = 0; i < sequences.size(); i++) {
      runLine(sequences.get(i).getSequence(), i);
    }
  }

  /*
  * <code>add</code> will add a value to the database
  * @param Object value the value to add to the database
  * @return boolean true if the value was added, false otherwise
  */
  public boolean add(Object value) {
    boolean success = false;
    if(ht.containsValue(value) == false) {
      //The current value is not a duplicate, continue adding it to the hashtable
      Object status = ht.putIfAbsent(value.hashCode(), value);
      if(status == null) {
        success = true;
      }
      else {
        success = false;
      }
    }
    else {
      success = false;
    }

    return success;
  }

  /*
    <code>size</code> will return the size of the database

    @return int size of the database
  */
  public int size() {
    return ht.size();
  }
}
