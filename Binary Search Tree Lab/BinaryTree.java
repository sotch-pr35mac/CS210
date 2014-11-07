/*

The BinaryTree Class

@author Autumn C. Spaulding <a href="mailto:autumn@max.cs.kzoo.edu">email</a>
Creation Date: 24 July 2000

Modifications:
    Modifier: Alyce Brady
    Modification Date: November 11, 2002
    Modifications Made: Modifications to documentation (e.g., to remove
        empty preconditions); added levelOrderTraversal;
        also modified to use NodeAction interface.

Modifications:
    Modifier: Preston Stosur-Bassett
    Modification Date: 1.11.14
    Modifications Made: Change Queue's to LLQueue and added LLQueue class to project

Description:
    This file contains some of the implementation of a BinaryTree class.
    It is intended as an outline and starting point for the "Binary Trees"
    lab in the Data Structures course.  The implementation is based on the
    recursive definition of a tree rather than on the graph theory definition
    of a tree (compare to Bailey, 190).

    A binary tree is either:
        1.  An empty tree; or
        2.  a node, called a root (the node contains the data), and two
            children, left and right, each of which are themselves binary trees.
                (Berman, "Data Structures via C++: Objects by Evolution", 1997.)

    In this implementation, an empty tree is represented by a node with null
    data and null references for the children.  A leaf node is represented by
    a node with a data value and two references to empty trees (NOT a data
    value and two null references!).  We could represent this as an object
    invariant: data, left, right are either all null (representing an empty
    tree) or none of them are null (a non-empty tree).

*/

public class BinaryTree
{
    //data:
    protected Object data;
    protected BinaryTree left;
    protected BinaryTree right;

    private int numberOfNodes = 0;
    private int numberOfLeaves = 0;
    private int depthOfTree = 0;
    private boolean containsObject = false;
    private int numberOfOccurances = 0;

    /*tested*/
    /** Creates an empty binary tree with no data and no children. */
    public BinaryTree()
    {
        //this is the contructor for the BinaryTree object
        data = null;
        left = null;
        right = null;
    }

    /*tested*/
    /** Tests whether this is an empty tree.
            @return true if the tree is empty; false otherwise
    */
    public boolean isEmpty()
    {
        return data == null;
    }

    /*tested*/
    /** Gets the data associated with the root node of this particular tree
        (recall recursive definition of trees).
            @return value associated with tree's root node;
                          null if tree is empty
    */
    public Object getElement()
    {
        return data;
    }

    /*
    * Sets all values associated with this tree to null
    */
    public void emptyElement() {
      data = null;
      left = null;
      right = null;
    }

    /*
    * Sets the data element of this tree to null
    */
    public void removeElement() {
      data = null;
    }

    /*tested*/
    /** Gets the left child of the current tree.
            @return the left child (a tree)
    */
    public BinaryTree leftTree()
    {
        return left;
    }

    /*tested*/
    /** Gets the right child of the current tree.
            @return the right child (a tree)
    */
    public BinaryTree rightTree()
    {
        return right;
    }

    /** Adds elements to a binary tree.  This implementation adds the
        elements in breadth-first (top-down, left-to-right) order.
            @param value the value to be added to the tree.
            @return true when the value has been added; should never return false
    */
    public boolean add(Object value)
    {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        while( ! queue.isEmpty() )
        {
            BinaryTree tree = (BinaryTree)queue.dequeue();

            //if the current position is null, then we know we can place a
            //value here.
            //place the value in that position in the tree, and create new
            //BinaryTrees for its children, which will both initially be null.
            if (tree.isEmpty())
            {
                tree.data = value;
                tree.left = new BinaryTree();
                tree.right = new BinaryTree();
                return true;
            }
            //otherwise, if the position is not null (that is, we can't place
            //it at the current position), then we add the left and right children
            //to the queue (if we can) and go back to the beginning of the loop.
            queue.enqueue(tree.left);
            queue.enqueue(tree.right);
        }
        return false;    //this statement should never be executed.
    }

	/** Traverses the tree in breadth-first order.
	        @param action an object that will act on all the nodes in the tree
	*/
	public void breadthFirstTraversal(NodeVisitor action)
	{
		LLQueue queue = new LLQueue();
		queue.enqueue(this);
		while( ! queue.isEmpty() )
		{
			BinaryTree tree = (BinaryTree)queue.dequeue();
			if ( ! tree.isEmpty() )
            {
    			action.visit(tree.getElement());
    			queue.enqueue(tree.leftTree());
    			queue.enqueue(tree.rightTree());
            }
		}
	}

  /*
    Traverses the tree in pre order using a recursive algorithm
      @param action a NodeVisitor that will act on all the nodes in the tree
      @param node a Binary Tree that is the tree to be traversed
  */
  public void recursivePreOrderTraversal(NodeVisitor action, BinaryTree node) {
    if(node != null) {
      //The tree is not empty
      action.visit(node.getElement());
      this.recursivePreOrderTraversal(action, node.leftTree());
      this.recursivePreOrderTraversal(action, node.rightTree());
    }
  }

  /*
    Traverses the tree in order using a recursive algorithm
    @param action a NodeVisistor that will act on all the nodes in the tree.
    @param node a BinaryTree that is the tree to be traversed
  */
  public void recursiveInOrderTraversal(NodeVisitor action, BinaryTree node) {
    if(node != null) {
      //The tree is not empty
      this.recursiveInOrderTraversal(action, node.leftTree());
      action.visit(node.getElement());
      this.recursiveInOrderTraversal(action, node.rightTree());
    }
  }

  /*
    Traverses the tree in post order using a recursive algorithm
    @param action a NodeVisitor that will act on all the nodes in the tree
    @param node a BinaryTree that is the tree to be traversed
  */
  public void recursivePostOrderTraversal(NodeVisitor action, BinaryTree node) {
    if(node != null) {
      //The tree is not empty
      this.recursivePostOrderTraversal(action, node.leftTree());
      this.recursivePostOrderTraversal(action, node.rightTree());
      action.visit(node.getElement());
    }
  }

  /*
    isLeaf will return true if the node that was passed to it was a leaf, false otherwise
    @param BinaryTree node the node to check leaf status of.
    @return boolean true if leaf, false otherwize
  */
  public boolean isLeaf(BinaryTree node) {
    if(node.leftTree() == null && node.rightTree() == null ) {
      return true;
    }
    return false;
  }

  /*
    calculateNumNodes calculates the number of nodes in a tree recusively
    A helper function for numNodes
    @param BinaryTree node the node to traverse and calculate the count of nodes for
  */
  private void calculateNumNodes(BinaryTree node) {
    if(node != null) {
      numberOfNodes++;
      this.calculateNumNodes(node.leftTree());
      this.calculateNumNodes(node.rightTree());
    }
  }

  /*
    numNodes will return the number of nodes of the tree that was passed to it.
    @param BinaryTree root the tree to count the nodes of
    @return int the integer count of how many nodes are in the tree.
  */
  public int numNodes(BinaryTree root) {
    numberOfNodes = 0;

    if(root != null) {
      calculateNumNodes(root);
    }

    return numberOfNodes;
  }

  /*
    A helper function for numLeaves
    calculateNumLeaves will calculate the number of leaves in a tree recursively
    @param BinaryTree node the tree to traverse and count the leaves of
  */
  private void calculateNumLeaves(BinaryTree node) {
    if(node != null) {
      if(node.leftTree() == null && node.rightTree() == null) {
        numberOfLeaves++;
      }

      this.calculateNumLeaves(node.leftTree());
      this.calculateNumLeaves(node.rightTree());
    }
  }

  /*
    numLeaves will return the number of leaves of the tree that was passed to it.
    @param BinaryTree root the tree to count the leaves of
    @return int the integer count of how many leaves are in the tree.
  */
  public int numLeaves(BinaryTree root) {
    numberOfLeaves = 0;

    if(root != null) {
      calculateNumLeaves(root);
    }

    return numberOfLeaves;
  }

  /*
    A helper function for depth
    calculateDepth calculates the depth of a tree by traversing its left side using recursion
    @param BinaryTree node the tree to traverse
  */
  private void calculateDepth(BinaryTree node) {
    if(node != null) {
      depthOfTree++;
      this.calculateDepth(node.leftTree());
    }
  }

  /*
    depth returns the depth of the tree that was passed to it
    @param BinaryTree tree the tree to traverse and count depth
    @return int the depth of the tree
  */
  public int depth(BinaryTree tree) {
    depthOfTree = 0;

    if(tree != null) {
      calculateDepth(tree);
    }

    return depthOfTree;
  }

  /*
    determineContains is a helper function for contains
    determineContains checks the equality of a given Object and the data of this node elemnts
    @param Object obj the Object to check equality for
    @param BinaryTree node the binary tree of nodes to check equality against
  */
  private void determineContains(Object obj, BinaryTree node) {
    if(node.getElement().equals(obj)) {
      containsObject = true;
    }
    else {
      this.determineContains(obj, node.leftTree());
      this.determineContains(obj, node.rightTree());
    }
  }

  /*
    contains returns a boolean value of whether or not an object exists in this binary tree
    @param Object obj the object to check equality for
    @return boolean true if the object is in the tree, false otherwise
  */
  public boolean contains(Object obj) {
    containsObject = false;

    determineContains(obj, this);

    return containsObject;
  }

  private void calculateOccurances(Object obj, BinaryTree tree) {
    if(tree.getElement().equals(obj)) {
      numberOfOccurances++;
    }

    this.calculateOccurances(obj, tree.leftTree());
    this.calculateOccurances(obj, tree.rightTree());
  }

  public int numOccurances(Object obj) {
    numberOfOccurances = 0;

    calculateOccurances(obj, this);

    return numberOfOccurances;
  }

  /*
  * <code>replaceElement</code> will replace the data attribute of this tree with the object passed to it.
  * @param Object replaceWith
  */
  public void replaceElement(Object replaceWith) {
    data = replaceWith;
  }

  /*
  * <code>reset</code> will reset the tree to be empty
  */
  public void reset() {
    data = null;
    left = new BST();
    right = new BST();
  }

  /*
  * <code>isLeaf</code> check to see if this node is a leaf or not
  * @return boolean true if node is leaf, false otherwise
  */
  public boolean isLeaf() {
    boolean returnStatement = false;
    if(this.leftTree().isEmpty() && this.rightTree().isEmpty()) {
      returnStatement = true;
    }

    return returnStatement;
  }
}    //end class BinaryTree
