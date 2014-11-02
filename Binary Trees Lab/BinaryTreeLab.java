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
		
		
		//insert elements in level order here.


		//traverse the tree in breadth-first order to see what you have done.
        NodeVisitor printer = new PrintAction();
		System.out.println("******Traversing Tree: breadth-first order******");
		// tree.breadthFirstTraversal(printer);
			
	}

}	//end class BinaryTreeLab
