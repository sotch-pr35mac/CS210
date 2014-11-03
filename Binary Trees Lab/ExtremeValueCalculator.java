/*
  ExtremeValueCalculator class
  @author Preston Stosur-Bassett
  Creation Date: 2.11.14

  The ExtremeValueCalculator implements NodeVisitor interface.
  It determines the largest and smallest values in a tree.
*/

public class ExtremeValueCalculator implements NodeVisitor {
  private Object largest;
  private Object smallest;

  public ExtremeValueCalculator() {
    largest = null;
    smallest = null;
  }

  /*
    visit method determines the largest and smallest values in the tree
    @param Object data
  */
  public void visit(Object data) {
    if(largest == null) {
      largest = data;
    }
    if(smallest == null) {
      smallest = data;
    }
    if(data.compareTo(largest) > 0) {
      largest = data;
    }
    if(data.compareTo(smallest) < 0) {
      smallest = data;
    }
  }

  /*
    getLargest returns the largest value of the traversed tree
    @return Object largest the largest value in the tree, null if tree has not been traversed
  */
  public Object getLargest() {
    return largest;
  }

  /*
    getSmallest returns the smallest value of the traversed tree
    @return Object smallest the smallest value in the tree, null if the tree has not been traversed
  */
  public Object getSmallest() {
    return smallest;
  }
}
