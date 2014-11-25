/*
* @Author: Preston Stosur-Bassett
* @Date: 25.11.14
* @Assignment: BLAST
* @Class: Simulation
* @Course: CS210
* @Description: This class gets the DNA data and the query data from the data readers.
                It has a run method that iterates through each query and displays any matches with substrings of the DNA data that are longer than a given threshold.
*/

import java.util.*;

public class Simulation {
  private Database db;
  private List<String> queriesList;
  private Integer threshold;
  private ArrayList<MatchElement> listOfMatchedElements;

  /*
  * <code>Simulation</code> creates a new database to store all the dna sequences
  */
  public Simulation() {
    db = new Database();
    listOfMatchedElements = new ArrayList<MatchElement>();
  }

  /*
  * <code>runner</code> runs the simulation
  */
  public void runner() {
    //Get input from user
    ValidatedInputReader validInput = new ValidatedInputReader();
    QueryReader queryReaderFile = new QueryReader(validInput.getString("What is the name of the query file you would like to use?", "Queries.txt"));
    threshold = new Integer(validInput.getInteger("Please provide a threshold value for the query.", 2, 60, 11, "The minimum value is 2, the maximum is 60."));
    queriesList = queryReaderFile.readData();

    //Search the index for matches and extentions on those matches
    for(int i = 0; i < queriesList.size(); i++) {
      ArrayList<MatchElement> elementsToAdd = db.search(queriesList.get(i), threshold);
      for(int y = 0; i < elementsToAdd.size(); i++) {
        listOfMatchedElements.add(elementsToAdd.get(i));
      }
    }

    /** Here I have all the matched elements, i suppose I should print them out now **/
    System.out.println(listOfMatchedElements);
  }
}
