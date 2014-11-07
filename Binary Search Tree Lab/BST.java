/*
* <code>BST</code> class is an implementation of a Binary Search Tree that extends Binary Tree
* @author Preston Stosur-Bassett
* @date 5.11.14
* @Course CS210 (Data Structures)
* @Assignment Binary Search Tree Lab
*/

public class BST extends BinaryTree {
  private Object leftMostElement;
  private boolean removed;
  public final boolean BST = true;
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
  * <code>findLeftMost</code> finds the leftmost node in the tree
  *   should find the smallest object in the tree
  *   A recursive helper function for leftmost() method.
  */
  public void findLeftMost(BST leftSide) {
    if(leftSide.leftTree().isEmpty()) {
      leftMostElement = leftSide.getElement();
    }
    else {
      BST searchTree = (BST)leftSide.leftTree();
      findLeftMost(searchTree);
    }
  }

  public void findAndDestoryLeftMost(BST leftSide) {
    if(leftSide.leftTree().isEmpty()) {
      leftMostElement = leftSide.getElement();
      leftSide.emptyElement();
    }
    else {
      BST searchTree = (BST)leftSide.leftTree();
      this.findAndDestoryLeftMost(searchTree);
    }
  }

  /*
  * <code>leftmost</code> returns the left most node from the binary search tree
  *   this should return the smallest value of the tree.
  * @return Object left-most node from the search tree, returns an Integer object of -1 if there was an error
  */
  public Object leftmost() {
    leftMostElement = null;
    if(this.leftTree().isEmpty()) {
      leftMostElement = this.getElement();
    }
    else {
      BST searchTree = (BST)this.leftTree();
      findLeftMost(searchTree);
    }

    return leftMostElement;
  }

  /*
  * <code>removeLeftMost</code> returns ths left most node and removes it from the tree
  *   this should remove and return the samllest value of the tree
  * @return Object leftmost element of the tree, returns null if tree is empty
  */
  public Object removeLeftMost() {
    leftMostElement = null;
    if(data != null && left.isEmpty() && right.isEmpty()) {
      this.findAndDestoryLeftMost(this);
    }

    return leftMostElement;
  }

  public void checkCompare(Object toRemove, BST checkTree) {
    Comparable removable = (Comparable)toRemove;
    Comparable checkable = (Comparable)checkTree.getElement();
    if(checkable.equals(removable)) {
      if(checkTree.isLeaf()) {
        checkTree.reset();
        removed = true;
      }
      else {
        if(checkTree.rightTree().isEmpty()) {
          //Right tree is empty, remove the whole thing
          checkTree.reset();
          removed = true;
        }
        else {
          //Right tree has element, move it to here
          Object tempElement = checkTree.leftmost();
          checkTree.reset();
          checkTree.replaceElement(tempElement);
          removed = true;
        }
      }
    }
    else {
      BST searchTree = (BST)checkTree.leftTree();
      checkCompare(toRemove, searchTree);
      checkCompare(toRemove, searchTree);
    }
  }

  /*
  * <code>remove</code> removes the given element from the tree
  * @return boolean true if the object was removed, false otherwise
  * @param Object the object to remove from the tree
  */
  public boolean remove(Object toRemove) {
    removed = false;
    checkCompare(toRemove, this);
    return removed;
  }

  /*
  * <code>equals</code> will check for equality in a BST
  * @param BST the other binary search tree to check equality for
  * @return boolean true if the binaries search trees are equal, false otherwise
  */
  public boolean equals(BST otherTree) {
    boolean returnStatement = false;
    Comparable otherElement = (Comparable)otherTree.getElement();
    Comparable thisElement = (Comparable)this.getElement();
    if(thisElement.equals(otherElement)) {
      returnStatement = true;
    }

    return returnStatement;
  }

  /*
  * <code>isBST</code> takes a tree and checks it to see if its a BST or not
  * @param BinaryTree Tree to check if it is a BST or not
  * @return true if the given BinaryTree is a BST, false otherwise
  */
  public static boolean isBST(BinaryTree checkTree) {
    boolean returnStatement = false;
    BST properCheckTree = (BST)checkTree;
    if(properCheckTree.BST == true) {
      returnStatement = true;
    }

    return returnStatement;
  }
}
