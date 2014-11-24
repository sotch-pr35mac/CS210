/*
	Author: Preston Stosur-Bassett
	Course: CS210 (Data Structures)
	Class: Location
	Date: Sept 23 2014
	Assignment: BLAST
	Description: This class will accept the sequence number and the index of the sequence and an A,B pair
*/

/**
	<code>Location</code> will accept the sequence number and the index of the sequence in an (A,B) pair

	@author Preston Stosur-Bassett
	@course CS210 (Data Structures)
	@date 23.09.14 (dd.mm.yy)
	@assignment Indexing Substrings
*/

public class Location {
	int sequenceNumber; //Store the Sequence Number as a integer primative
	int sequenceIndex; //Store the Index of the Sequence as an integer primative

	/**
		<code>Location</code> constructor will initialize a location object to store the sequence number and the index of the sequence

		@param int sNumber  	The Sequence Number
		@param int sIndex  		The Index of the sub-sequence
	*/
	public Location(int sNumber, int sIndex) {
		//Store the passed values in their respective values inside this Location object
		sequenceNumber = sNumber;
		sequenceIndex = sIndex;
	}

	/**
		<code>toString</code> will return a string of the sequence number and the index of the sub-sequence in an (x,y) format, respectively.

		@return String  	The sequence location in (x,y) format, where x is the sequence number, and y is the index of that sub-sequence
	*/
	public String toString() {
		//Convert the sequenceNumber integer primative and the sequenceIndex integer primative to String objects.
		String stringSequence = String.valueOf(sequenceNumber);
		String stringIndex = String.valueOf(sequenceIndex);

		//Return the String values of the sequenceNumber and sequenceIndex as a String.
		return ("("+stringSequence+", "+stringIndex+")");
	}

	/**
		<code>getSequenceNumber</code> will return the <code>sequenceNumber</code> integer primitive

		@return int 	<code>sequenceNumber</code>, which is just the sequence number (x-half) of the location
	*/
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
		<code>getSequenceIndex</code> will return the <code>sequenceIndex</code> integer primitive

		@return int 	<code>sequenceIndex</code>, which is just the sub-sequence index (y-half) of the location
	*/
	public int getSequenceIndex() {
		return sequenceIndex;
	}

	/**
		<code>equals</code> will accelt a location object and check to see if that location object is the same as this location object. If they are the same, it will return true, otherwise, false.

		@param Location otherLocation 	A Location to check this location against to see if they are the same location or not
		@return boolean 	Returns true of this location is in fact the location that was passed as an argument.
	*/
	public boolean equals(Location otherLocation) {
		if(otherLocation.getSequenceNumber() == this.getSequenceNumber()) {
			if(otherLocation.getSequenceIndex() == this.getSequenceIndex()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
