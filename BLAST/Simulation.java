/*
* @Author: Preston Stosur-Bassett
* @Date: 25.11.14
* @Assignment: BLAST
* @Class: Simulation
* @Course: CS210
* @Description: This class gets the DNA data and the query data from the data readers.
                It has a run method that iterates through each query and displays any matches with substrings of the DNA data that are longer than a given threshold.
*/

public class Simulation {
  private Database db;
  private ArrayList<LocsList> locsList;

  /*
  * <code>Simulation</code> creates a new database to store all the dna sequences
  */
  public Simulation() {
    db = new Database();
  }

  /*
  * <code>runner</code> runs the simulation
  */
  public void runner() {
    ValidatedInputReader validInput = new ValidatedInputReader();
    String query; //The query to check against the database
    Integer threshold; //the threshold of acquracy for the query
    // Get the query information from the user
    query = new String(validInput.getString("What is the query you could like to make against the database?", "ACCT"));
    query = query.toLowerCase();
    threshold = new Integer(validInput.getInteger("Please provide a threshold value for the query.", 2, 60, 11, "The minimum value is 2, the maximum is 60."));

    locsList = db.search(query);
    if(locsList == null) {
      System.out.println("There were no matching DNA Sequences associated with that query.");
    }
    else {
      for(int i = 0; i < locsList.size(); i++) {
        Location currentLocation = locsList.get(i);
        DNASequence currentSequence = db.getFullSequence(currentLocation.getSequenceNumber());
        
      }
    }
  }
}
