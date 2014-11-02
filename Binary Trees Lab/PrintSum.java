/*
  PrintSum class.
  @author Preston Stosur-Bassett
  Creation Date: 1.11.14

  The PrintSum class implements NodeVisitor interface.
  It prints out the sum of the contents of a tree to System.out.
*/

public class PrintSum implements NodeVisitor {
  private int completeSum = 0;
  public PrintSum() {
  }

  /*
    visit method calculates the complete sum of the binary tree.
    @param Integer data
  */
  public void visit(Object data) {
    if(data != null) {
      int value = (Integer) data;
      completeSum += value;
    }
  }

  /*
    result prints the complete sum calculated by the calculate method
  */
  public void result() {
    Integer completeSumObject = new Integer(completeSum);
    String completeSumString = completeSumObject.toString();
    System.out.println(completeSumString);
  }
}
