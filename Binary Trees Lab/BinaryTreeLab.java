/*
	Main file for Binary Tree Lab
	@author Autumn C. Spaulding
	Creation Date: 24 July 2000

	More thorough documentation may be found within the BinaryTree class file.
*/

public class BinaryTreeLab
{

	public static void main(String args[])
	{
		// Debug.turnOn();
		Debug.turnOff();


		//construct an empty binary tree here.
		BinaryTree tree = new BinaryTree();


		//insert elements in level order here.
		tree.add(new Integer(12));
		tree.add(new Integer(7));
		tree.add(new Integer(3));
		tree.add(new Integer(4));
		tree.add(new Integer(8));
		tree.add(new Integer(25));
		tree.add(new Integer(0));
		tree.add(new Integer(142));
		tree.add(new Integer(17));
		tree.add(new Integer(26));


		//traverse the tree in breadth-first order to see what you have done.
        NodeVisitor printer = new PrintAction();
		System.out.println("******Traversing Tree: breadth-first order******");
		// tree.breadthFirstTraversal(printer);

	}

}	//end class BinaryTreeLab
