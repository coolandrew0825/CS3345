package project3;

import java.util.Scanner;

// Course:	CS 3345
// Assignment:	project 3
// Compiler:	Eclipse
// Description:
// User will run this program to create an user interface.

public class RedBlackTreeTest {
	public static void main(String[] args){
		
		// input scanner
		Scanner input = new Scanner(System.in);
		
		// Creating object
		RBTree2 rbt = new RBTree2(Integer.MIN_VALUE); 
		
		// continue to ask user for input
		while(true){
			// menu
			System.out.println("1. insert ");
			System.out.println("2. contains");
			System.out.println("3. print tree");
			
			// user input
			System.out.print("Your Option: ");
			int choice = input.nextInt();
           
			switch (choice){
			case 1:
				// user input
				System.out.print("Element: ");
				rbt.insert(input.nextInt());
				
				// print out
				System.out.println("Element inseted");
				System.out.println();
				break;                          
			case 2: 
				// user input
				System.out.print("What element do you want to search for?");
				
				if(rbt.contains(input.nextInt()) == true){
					// print out
					System.out.println("Search result: This element is in the tree.");
				} else {
					// print out
					System.out.println("Search result: This element is not in the tree.");
				}
				
				System.out.println();
				break;                                          
			case 3:
				// display tree
				System.out.print("RB Tree: ");
				rbt.inorder();
				System.out.println();
				break;    
			default:
				System.out.println("Wrong Entry \n ");
				System.out.println();
				break;	
			}
		} // end of while loop
    } // end of main method
} // end of of RedBlackTreeTest
