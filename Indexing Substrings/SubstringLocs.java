/*
	Author: Preston Stosur-Bassett
	Course: CS210 (Data Structures)
	Class: SubstringLocs
	Date: Sept 24 2014
	Assignment: Indexing Substrings
	Description: This class will store an object that pairs a specific substring and all its locations are. It will accept a String object for the specific substring and a Location object for all the locations. 
*/

/**
	<code>SubstringLocs</code> will store an object that pairs a specific substring and all its locations.

	@author Preston Stosur-Bassett
	@course CS210 (Data Structures)
	@date 24.09.14 (dd.mm.yy)
	@assignment Indexing Substrings
*/

import java.util.ArrayList;

public class SubstringLocs {
	String sequence; //A String object to store the sequence name
	ArrayList<Location> sequenceLocs = new ArrayList<Location>(2); //An ArrayList object to store all the Location objects for the sequence

	/**
		<code>SubstringLocs</code> constructor will intialize a SubstringLocs object that has the sequence name and an ArrayList with one element in it that is the location of the first appearance of the sub-sequence.

		@param String sequenceString 	The DNA sub-sequence to store the locations of
		@param Location firstLocation 	The first appearance of this sub-string as a <code>Location</code> object
	*/
	public SubstringLocs(String sequenceString, Location firstLocation) {
		//Store the sequenceString to the sequence String object for the SubstringLocs object
		sequence = sequenceString;
		//Store the first location being passed as an argument to the constructor as the first element in the sequenceLocs ArrayList of Locations
		sequenceLocs.add(firstLocation);
	}

	/**
		<code>toString</code> will create a String that will add the sequence name and a list of all the location attached to it.

		@return String 	The sequence name and a list of it's locations
	*/
	public String toString() {
		String toPrint = sequence+":"; //Initialize the String that will be printed to the console and the String that will be returned, it will be in the format "Sequence: (x,y), (x,y),"
		for(int i = 0; i < sequenceLocs.size(); i++) {
			//Add the location pairs to the toPrint String
			toPrint = toPrint +" "+ sequenceLocs.get(i).toString();
		}

		return toPrint;
	}

	/**
		<code>getSequenceName</code>

		@return String 	returns the <code>sequence</code> variable, which is the sequence itself.
	*/
	public String getSequenceName() {
		return sequence;
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