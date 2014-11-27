/*
* @author: Preston Stosur-Bassett
* @date: 25.11.14
* @class: MatchElement
* @course: CS210
* @description:  This class stores information for each match longer than a given threshold.
*/

import java.util.*;

public class MatchElement {
  private String subSequenceName;
  private ArrayList<Location> locationListing;
  private int score;

  /*
    <code>MatchElement</code> contains all the locations and sequence names of the locations that were matched from a query and the database
  */
  public MatchElement(String subSeq, ArrayList<Location> listing, int scoredValue) {
    this.subSequenceName = subSeq;
    this.locationListing = listing;
    this.score = scoredValue;
  }

  /*
    <code>getSubSeq</code> will return the subsequence asscociated with this MatchElement

    @return String subSequenceName
  */
  public String getSubSeq() {
    return subSequenceName;
  }

  /*
    <code>equals</code> will check for equality by checking the subSequenceName value of a given MatchElement against {this} subSequenceValue

    @param MatchElement checkAgainst the element to check for equality against
    @return boolean true if the eleemnts are equal, false otherwise
  */
  public boolean equals(MatchElement checkAgainst) {
    return this.subSequenceName.equals(checkAgainst.getSubSeq());
  }

  /*
    <code>toString</code> overrides the default Object.toString() method to return a string of this object instance when it is called.

    @return String subSequenceName, the subsequence stored in this element
  */
  public String toString() {
    return subSequenceName;
  }
}
