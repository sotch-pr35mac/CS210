/*
  Author: Preston Stosur-Bassett
  Course: CS210 (Data Structures)
  Class: LocsList
  Date: Nov 25 2014
  Assignment: BLAST
  Description: This class will store a list of Location objects
*/
import java.util.ArrayList;

public class LocsList {
  private ArrayList<Location> sequenceLocs = new ArrayList<Location>(2); //An ArrayList object to store all the Location objects for the sequence

  /**
    <code>LocsList</code> constructor will intialize a SubstringLocs object that has an ArrayList with one element in it that is the location of the first appearance of the sub-sequence.

    @param Location firstLocation 	The first appearance of this sub-string as a <code>Location</code> object
  */
  public LocsList(Location firstLocation) {
    //Store the first location being passed as an argument to the constructor as the first element in the sequenceLocs ArrayList of Locations
    sequenceLocs.add(firstLocation);
  }

  /**
    <code>toString</code> will create a String that will add the sequence name and a list of all the location attached to it.

    @return String 	The sequence name and a list of it's locations
  */
  public String toString() {
    String toPrint = new String();
    for(int i = 0; i < sequenceLocs.size(); i++) {
      //Add the location pairs to the toPrint String
      toPrint = toPrint +" "+ sequenceLocs.get(i).toString();
    }

    return toPrint;
  }

  /*
    <code>size</code> will return the size of the the list of the locations

    @return int size of the list of locations
  */
  public int size() {
    return sequenceLocs.size();
  }

  /**
    <code>addLocation</code> will accept a <code>Location</code> object for a new location of the sequence and will add it to the sequence ArrayList of Locations

    @param Location newLocation 	The new location object to store in the <code>sequenceLocs</code> ArrayList
  */
  public void addLocation(Location newLocation) {
    //Add the passed Location object to the end of the ArrayList of Locations
    sequenceLocs.add(newLocation);
  }

  /**
    <code>removeLocation</code> will accept an integer primitive to be used as an index value in the sequences ArrayList to remove the location at that index from the ArrayList

    @param int locationIndex 	The index of the location to remove
  */
  public void removeLocation(int locationIndex) {
    sequenceLocs.remove(locationIndex);
  }

  /**
    <code>updateLocation</code> will accept and integer primitive to be used as an index value in the sequences ArrayList to update the location at that index with the updated <code>Location</code> object that was passed as an argument

    @param int locationIndex 	The index of the location to update
    @param Location newLocation The new location to update with
  */
  public void updateLocation(int locationIndex, Location newLocation) {
    System.out.println(sequenceLocs.get(locationIndex));
  }

  /**
    <code>getLocationIndex</code> will accept a location object and return that object's index in the sequence ArrayList, if the location does not exist in the ArrayList it will return -1

    @param Location existingLocation 	The <code>Location</code> object to find the index for
    @return int 	return the index of the <code>Location</code> object that was passed as an argument, if the index of that object was not found, return -1
  */
  public int getLocationIndex(Location existingLocation) {
    for(int i = 0; i < sequenceLocs.size(); i++) { //The index is the value to be returned if it is the index value of the existing location parameter
      //Check to see if they are equals and then return the index if they do; returns -1 if they do not
      if(sequenceLocs.get(i).equals(existingLocation) == true) {
        return i;
      }
    }
    return -1;
  }
}
