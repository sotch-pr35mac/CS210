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

  /*
  * <code>Database</code> will contrcut a database based off the data present in a file
  */
  public Database() {
    //Ask the user what the filename is of the file they want to use to build the database off of
    ValidatedInputReader validInput = new ValidatedInputReader();
    String filename = new String(validInput.getString("Please provide the name of the file you would like to use to build the database.", "DNAData.txt"));
    DNADataReader dataReader = new DNADataReader(filename);

    sequences = dataReader.readData();

    ht = new Hashtable(substrings.size()*5);

    this.build();
  }

  /*
    <code>runLine</code> will run through a line of DNA sequence passed to it and scan for all the subsequences in it.

    @param String currentSequence The current DNA sequence to scan through for sub-sequences
    @param int lineNumber the line number of the <code>currentSequence</code> String
  */
  private void runLine(String currentSequence, int lineNumber) {
    int startIndex = 0; //The start index of the substring
    int endIndex = 11; //The end index of the substring
    while(endIndex <= currentSequence.length()) {
      String currentSubstring = currentSequence.substring(startIndex, endIndex); //The current substring of the current sequence
      Location currentLocation = new Location(lineNumber, startIndex); //The current location for the current substring

      if(ht.containsKey(currentSubstring) == false) {
        LocsList newLocList = new LocsList(currentLocation);
        ht.put(currentSubstring, newLocList);
      }
      else {
        ht.get(currentSubstring).addLocation(currentLocation);
      }

      startIndex++;
      endIndex++;
    }
  }

  /*
    <code>getFullSequence</code> will return the full sequence from the provided index value

    @param int index of the sequence to return
    @return DNASequence the sequence of the given index value, if not sequence with that value is found, return -1
  */
  public DNASequence getFullSequence(int index) {
    if(i > sequences.size() - 1 || i < 0) {
      System.out.println("The sequence you requested was out of bounds.");
      return -1;
    }

    return sequences.get(i);
  }

  /*
    <code>search</code> will return an array list of locslist's in the database that match the query

    @param String query the characters to match
    @return ArrayList<LocsList> list of matching locs, returns null if not matches were found.
  */
  public ArrayList<LocsList> search(String query) {
    if(ht.containsKey(query)) {
      return ht.get(query);
    }

    return null;
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
      boolean status = ht.putIfAbsent(value.hashCode(), value);
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
