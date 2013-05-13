package DataStructures;

import java.util.Arrays;

public class StackStructure {
	
	private String[] stackArray;
	
	private int stackSize;
	
	private int topOfStack = -1;
	
	StackStructure (int size) {
		
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill (stackArray, "-1");
		
	}
	
	public void push (String input) {
		
		if (topOfStack + 1 < stackSize) {
			
			topOfStack++;
			
			stackArray[topOfStack] = input;
			
		} else System.out.println ("The Stack is full");
		
		displayTheStack ();
		
		System.out.println("PUSH " + input + "was added to the Stack");
	}
	
	public String pop () {
		
		if (topOfStack >= 0) {
			
			displayTheStack ();
			
			System.out.println ("POP " + stackArray[topOfStack] + " was removed ");
			
			stackArray[topOfStack] = "-1";
			
			return stackArray[topOfStack--];
			
		} else {
			
			displayTheStack();
			System.out.println ("The Stack is empty!");
			
			return "-1";
			
		}
	}
	
	public String peek () {
		
		displayTheStack ();
		
		System.out.println ("PEEK " + stackArray[topOfStack] + " is at the top of the Stack");
		
		return stackArray[topOfStack];
		
	}
	
	public void displayTheStack () {
		
		for (int n = 0; n < 61; n++) System.out.print("-");
		
		System.out.println();
		
		for (int n = 0; n < stackSize; n++) {
			
			System.out.format("| %2s " + " ", n);
			
		}
		
		System.out.println("|");
		for (int n = 0; n < stackSize; n++) {
			
			if (stackArray[n].equals("-1")) System.out.print ("|  ");
			else System.out.print(String.format("| %2s " + " ", stackArray[n]));
			
		}
		
		System.out.println("|");
		
		for (int n = 0; n < 61; n++) System.out.print("-");
		System.out.println();
		
	}
	
	public static void main (String[] args) {
		
		StackStructure stack = new StackStructure (10);
		
		stack.push("10");
		
		stack.push("15");
		
		stack.peek();
		stack.pop();
		
		stack.displayTheStack();
		
	}
	
}
