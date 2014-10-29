/**
*	<code>DataReader</code> will read in a <code>String</code> from the user and test to make sure that its nests line up by adding and removing: "(", ")", "{", "}", "[", "]" from a stack.
* @author Preston Stosur-Bassett
* @date October 6th, 2014
* @Course CS210 (Data Structures)
* @Assignment Stacks Mini-Lab (Nesting)
*/
public class DataReader {
	public static void main(String[] args) {
		//Iniitailize a new stack
		Stack<String> characterStack = new Stack<String>();
		boolean thereWasError = false;

		//String type variables that will hold the value of open and closed nesting elements
		String openParen = new String("(");
		String closedParen = new String(")");
		String openBracket = new String("{");
		String closedBracket = new String("}");
		String openBrace = new String("[");
		String closedBrace = new String("]");

		//Variables to keep track of whether or not nesting is proper
		String currentCharacter;
		String topOfStack;

		//Read the contents of a given file and run through it
		String fileContents = ValidatedInputReader.getString("Paste your code here...", "();");

		//Cycle through the fileContents and check to make sure all the nesting is proper using a stack to do so. 
		for(int i = 0; i < fileContents.length(); i++) {
			currentCharacter = Character.toString(fileContents.charAt(i));
			if(currentCharacter.equals(openBracket) || currentCharacter.equals(openParen) || currentCharacter.equals(openBrace)) {
				//Open character add it to the stack
				characterStack.push(currentCharacter);
			}
			else if(currentCharacter.equals(closedBracket)) {
				//Closed character, check to see if it is at the top of the stack, if not, report an error to the user.
				if(characterStack.isEmpty()) { //If stack is empty and closed bracket is found report to user the document is missing an open bracket
					System.out.println("Uh-oh! It looks like one of the '{' is missing in your document.");
					System.out.println("Found at string index: "+i);
					System.out.println(" ");
					thereWasError = true;
				}
				else {
					//If the an opening bracket is not first on the queue, report to the user that they're brackets are not lined up
					topOfStack = characterStack.pop();
					if(!topOfStack.equals(openBracket)) {
						System.out.println("Uh-oh! It looks like one of the '}' in your file doesn't match up.");
						System.out.println("Found at string index: "+i);
						System.out.println(" ");
						thereWasError = true;
					}
				}
			}
			else if(currentCharacter.equals(closedParen)) {
				//Closed character, check to see if is at the top of the stack, if not, report an error to the user. 
				if(characterStack.isEmpty()) { //If stack is empty and closed parenthesis is found, report to the user that the document is missing an opening parathensis
					System.out.println("Uh-oh! It looks like one of the '(' is mising in your document.");
					System.out.println("Found at string index: "+i);
					System.out.println(" ");
					thereWasError = true;
				}
				else {
					//If an opening paranthesis is not the first on the stack, report to the user that their parathensis are not lined up
					topOfStack = characterStack.pop();
					if(!topOfStack.equals(openParen)) {
						System.out.println("Uh-oh! It looks like one of the ')' in your files doens't match up.");
						System.out.println("Found at string index: "+i);
						System.out.println(" ");
						thereWasError = true;
					}
				}
			}
			else if(currentCharacter.equals(closedBrace)) {
				//Closed character, check to see if is at the top of the stack, if not, report an error to the user.
				if(characterStack.isEmpty()) { //If the stack is empty and closed braces are found report to the user that they are mssing a closing parathensis
					System.out.println("Uh-oh! It looks like one of the '[' is your document is missing.");
					System.out.println("Found at string index: "+i);
					System.out.println(" ");
					thereWasError = true;
				}
				else {
					//If an opening brace is not thre first on the stack let the user know that their braces are not lined up.
					topOfStack = characterStack.pop();
					if(!topOfStack.equals(openBrace)) {
						System.out.println("Uh-oh! It looks like one of the ']' in your files doesn't match up.");
						System.out.println("Found at string index: "+i);
						System.out.println(" ");
						thereWasError = true;
					}
				}
			}
		}

		//Check to see if any nesting is left open or extra at the bottom of the file
		if(!characterStack.isEmpty()) {
			System.out.println("Uh-oh! Your file contains incomplete nests.");
			thereWasError = true;
		}

		//Tell the user the scan of their file completes
		System.out.println("Scan complete.");
		if(thereWasError == false) {
			System.out.println("Great job, your code all lines up.");
		}
		else {
			System.out.println("You've got some nesting issues to take care of because you can continue...");
		}
	}
}