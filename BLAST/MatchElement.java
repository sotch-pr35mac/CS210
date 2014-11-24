/*
* @author: Preston Stosur-Bassett
* @date: 25.11.14
* @class: MatchElement
* @course: CS210
* @description:  This class stores information for each match longer than a given threshold.
*/

public class MatchElement {
  private String subSequenceName;
  private ArrayList<Location> locationListing;

  public MatchElement(String subSeq, ArrayList<Location> listing) {
    this.subSequenceName = subSeq;
    this.locationListing = listing;
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
}
