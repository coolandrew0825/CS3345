package project1;

// Name:		Andrew Chen
// Course:		CS 3345
// Date:		02/14/16
// Assignment:	project 1
// Compiler:	Eclipse
// Description:
// This program creates user interface.

import java.util.Scanner;

public class TestMagazine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// input scanner
		Scanner input = new Scanner (System.in);
		
		// creating instance of MagazineList class
		MagazineList mag1 = new MagazineList();
		
		// variables declaration
		int choice = 0;
		int mgID = 0;
		String mgName = "";
		String pbName = "";
		
		// this loop won't stop till a false value appears
		while(true){
			// print out
			System.out.println("Operations on List");
			System.out.println("1. Make Empty");
			System.out.println("2. Find ID");
			System.out.println("3. Insert At Front");
			System.out.println("4. Delete From Front");
			System.out.println("5. Delete ID");
			System.out.println("6. Print ID");
			System.out.println("7. Print All Records");
			System.out.println("8. Done");
			
			// user input
			System.out.print("Your choice: ");
			choice = input.nextInt();
			
			switch (choice){
			case 1:
				mag1.makeEmpty();
				break;
			case 2:
				// user input
				System.out.print("Enter Magazine ID: ");
				mgID = input.nextInt();
				
				Magazine newMag = mag1.findID(mgID);
				newMag.printMag();
				break;
			case 3:
				// user input
				System.out.print("Enter Magazine ID: ");
				mgID = input.nextInt();
				
				// user input
				System.out.print("Enter Magazine Name (without space): ");
				mgName = input.next();
				
				// user input
				System.out.print("Enter Publisher Name (without space): ");
				pbName = input.next();
				
				if (mag1.insertAtFront(new Magazine (mgID, mgName, pbName))){
					// print out
					System.out.println("Magazine Added");
					System.out.println();
					break;
				}
			case 4:
				newMag = mag1.deleteFromFront();
				newMag = printMag();
				
				// print out
				System.out.println("First item deleted");
				System.out.println();
				break;
			case 5:
				// user input
				System.out.print("Enter Magazine ID: ");
				mgID = input.nextInt();
				
				if(mag1.delete(mgID)){
					// print out
					System.out.println("The item was deleted.");
					System.out.println();
				}
				break;
			case 6:
				// user input
				System.out.print("Enter Magazine ID; ");
				mgID = input.nextInt();
				
				if (mag1.printRecord(mgID)){
					// print out
					System.out.println("Printed");
					System.out.println();
				}
				break;
			case 7:
				mag1.printAllRecords();
				break;
			case 8:
				// print out
				System.out.println("Done.");
				System.out.println();
				System.exit(1);
			} // end of switch
		} // end of while loop
	} // end of main method

	private static Magazine printMag() {
		// TODO Auto-generated method stub
		return null;
	}
} //end of TestMagazine class
