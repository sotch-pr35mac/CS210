/*
	Author: Preston Stosur-Bassett
	Course: CS210 (Data Structures)
	Class: DNASequence
	Date: Sept 22 2014
	Assignment: Indexing Substrings
	Description: Provides the blueprints for DNASequence Objects that will be used to organize and store information about DNA sequences read from a given file
*/

/**
	<code>DNASequence</code> provides the blueprints for DNASequence Objects that will be used to organize and store information about DNA sequences read from a given file

	@author Preston Stosur-Bassett
	@course CS210 (Data Structures)
	@date 22.09.14 (dd.mm.yy)
	@assignment Indexing Substrings
*/

public class DNASequence {
	private String sequenceGeneralInformation = null;
	private String sequenceName = null;
	private String sequence = null;
	/**
		<code>DNASquence</code> constructor will expect three Strings as parameters and store those values in the object.

		@param genInfo   The general information associated with the peticular sequence
		@param name   The name of the sequence
		@param seq   The sequence itself
	*/
	public DNASequence(String genInfo, String name, String seq) {
		sequenceGeneralInformation = genInfo;
		sequenceName = name;
		sequence = seq;
	}
	/**
		<code>toString</code> will return a well-formed string with the complete information about the sequence.
		@return String  	All the information associated with this DNA Sequence
	*/
	public String toString() {
		return "GI: "+sequenceGeneralInformation+"; Name: "+sequenceName+"; Sequence: "+sequence+";";
	}
	/**
		<code>getGeneralInfo</code> will return a string with the sequences general information.
		@return String  	the GI
	*/
	public String getGeneralInfo() {
		return sequenceGeneralInformation;
	}
	/**
		<code>getName</code> will return a string with the sequences name.
		@return String  	the name of the Sequence
	*/
	public String getName() {
		return sequenceName;
	}
	/**
		<code>getSequence</code> will return a string with the sequence itself.
		@return String  	the Sequence itself
	*/
	public String getSequence() {
		return sequence;
	}
}