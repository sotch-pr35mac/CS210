/*
* <code>BST</code> class is an implementation of a Binary Search Tree that extends Binary Tree
* @author Preston Stosur-Bassett
* @date 5.11.14
* @Course CS210 (Data Structures)
* @Assignment Binary Search Tree Lab
*/

public class BST extends BinaryTree {
  /*
  * Adds element to a binary search tree. This implementation adds the elements in sorted order.
  * @param Object value the value to add to the binary search tree
  * @return boolean true when the value has been added, returns false if fails or duplicate is passed
  */
  @Override
  public boolean add(Object value) {
    if(data == null && left == null && right == null) {
      //This Binary Search Tree is empty, fill it in
      data = value;
      left = new BST();
      right = new BST();
      return true;
    }
    else {
      Comparable comparableValue = (Comparable)value;
      Comparable comparableElement = (Comparable)data;
      if(comparableElement.compareTo(comparableElement) > 0) {
        //The value passed to the add method is larger than the data in this node
        //Now add to the right node.
        boolean status = right.add(value);
        return status;
      }
      else if(comparableElement.compareTo(comparableElement) < 0) {
        //The value passed to the add method is smaller than the data in this node
        //Now add to the left node.
        boolean status = left.add(value);
        return status;
      }
      else if(comparableElement.compareTo(comparableElement) == 0) {
        //The value passed to the add method is a duplicate of the data in the Binary Search Tree, duplicates not allowed
        System.out.println("Duplicate value passed to add, duplicates not allowed. Returning false.");
        return false;
      }
    }

    return false; //this statement should never rurn
  }

  /*
  * <code>leftmost</code> returns the left most node from the binary search tree
  *   this should return the smallest value of the tree.
  * @return Object left-most node from the search tree, returns an Integer object of -1 if there was an error
  */
  public Object leftmost() {
    if(this.leftTree().isEmpty()) {
      return this;
    }
    else {
      findLeftMost(this.leftTree());
    }

    Integer invalid = new Integer(-1);
    return invalid; //Should never rurn
  }
}
