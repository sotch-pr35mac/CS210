/*
	Main file for Binary Tree Lab
	@author Autumn C. Spaulding
	Creation Date: 24 July 2000

	Modifications By: Preston Stosur-Bassett
	Modifications Date: 1.11.14
	Modifacations Description: Updated main method to traverse through a binary tree

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
		tree.breadthFirstTraversal(printer);

		//traverse the tree and calculate the sum
		PrintSum calculator = new PrintSum();
		System.out.println("******Traversing Tree: calculating sum******");
		tree.breadthFirstTraversal(calculator);
		//Print out the results
		calculator.result();

		//traverse the tree in recursive pre order to see what you have done.
		System.out.println("******Traversing Tree: Recursive Pre-Order******");
		tree.recursivePreOrderTraversal(printer, tree);

		//traverse the tree in recursive in order to see what you have done
		System.out.println("******Traversing Tree: Recursive In-Order******");
		tree.recursiveInOrderTraversal(printer, tree);

		//traverse the tree in recursive post order to see what you have done
		System.out.println("******Traversing Tree: Recursive Post-Order******");
		tree.recursivePostOrderTraversal(printer, tree);

		//traverse the tree and determine the smallest and largest values
		NodeVisitor extremes = new ExtremeValueCalculator("Integer");
		System.out.println("******Traversing Tree: Calculating the Smallest and Largest Values******");
		tree.breadthFirstTraversal(extremes);
		ExtremeValueCalculator extremeValues = (ExtremeValueCalculator)extremes;
		System.out.println("Largest: "+extremeValues.getLargest());
		System.out.println("Smallest: "+extremeValues.getSmallest());
	}

}	//end class BinaryTreeLab
