package project5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// input scanner
		Scanner input = new Scanner(System.in);
		
		// create instance of Random class
		Random randomNum = new Random();
		
		// print out
		System.out.println("menu of different sizes");
		System.out.println("1. 100");
		System.out.println("2. 1000");
		System.out.println("3. 5000");
		System.out.println("4. 10000");
		System.out.println("5. 50000");
		System.out.println();
		
		// variable declaration
		int size = 0;
		
		// user input
		System.out.println("Please choose a size from the menu: ");
		size = input.nextInt();
		
		// variables declaration
		int[] ranArray = new int[size];
		
		// variables initialization
		for(int count = 0; count < size; ++count){
			// randomly assign number into the array
			int num = randomNum.nextInt(60000);
			ranArray[count] = num;
		} // end of for loop
		
		System.out.println();
		
		PrintStream out = null;
		
		try {
			out = new PrintStream(new FileOutputStream("unsorted.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// print out unsorted array
		for (int count : ranArray) {
			System.out.println(count);
			System.setOut(out);
		} // end of for loop
		
		// closing file
		out.close();
		
		// calling quick sort function
		qSort(ranArray);
		
		// space
		System.out.println();
		
		PrintStream out2 = null;
		
		try {
			out2 = new PrintStream(new FileOutputStream("sorted.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// print out sorted array
		for (int count : ranArray){
			System.out.println(count);
			System.setOut(out2);
		} // end of for loop
		
		// close file
		out2.close();
	} // end of main method
	
	public static void qSort(int[] ranArray) {
		// calling recQuickSort function
		recQSort(ranArray, 0, ranArray.length - 1);
	} // end of qSort function
	
	public static void recQSort(int[] ranArray, int l, int r) {
		// variable declaration
		int size = 0;
		double medianValue = 0.0;
		int partition = 0;
		
		// calculation
		size = r - l + 1;
	    
		if (size <= 3){
			manSort(ranArray, l, r);
		} else {
			medianValue = medianOfThree(ranArray, l, r);
			partition = partitionIt(ranArray, l, r, medianValue);
			
			recQSort(ranArray, l, partition - 1);
			recQSort(ranArray, partition + 1, r);
		}
	} // end of recQSort function
	
	public static int medianOfThree(int[] ranArray, int l, int r) {
	    // variable declaration
		int center = 0;
		
		// calculation
		center = (l + r) / 2;

	    if (ranArray[l] > ranArray[center]){
	    	swapping(ranArray, l, center);
	    }

	    if (ranArray[l] > ranArray[r]){
	    	swapping(ranArray, l, r);
	    }

	    if (ranArray[center] > ranArray[r]){
	    	swapping(ranArray, center, r);
	    }

	    // calling swapping function
	    swapping(ranArray, center, r - 1);
	    
	    // return statement
	    return ranArray[r - 1];
	  } // end of medianOfThree function
	
	public static void swapping(int[] ranArray, int d1, int d2) {
	    // variable declaration
		int temp = 0;
		
		// calculation
		temp = ranArray[d1];
	    
		ranArray[d1] = ranArray[d2];
	    ranArray[d2] = temp;
	} // end of swapping method

	public static int partitionIt(int[] ranArray, int l, int r, double pivot) {
		// variable declaration
		int lPtr = l;
	    int RPtr = r - 1;

	    while (true){
	    	while (ranArray[++lPtr] < pivot)
	    		;
	    	while (ranArray[--RPtr] > pivot)
	    		;
	    	if (lPtr >= RPtr){
	    		break;
	    	} else {
	    		swapping(ranArray, lPtr, RPtr);
	    	}
	    } // end of while loop
	    
	    // calling swapping function
	    swapping(ranArray, lPtr, r - 1);
	    
	    // return statement
	    return lPtr;
	} // end of partitionIt function
	
	public static void manSort(int[] ranArray, int l, int r) {
		// variable declaration
		int size = 0; 
		
		// calculation
		size = r - l + 1;
		
		if (size <= 1){
			return;
		}
		 
		if (size == 2) {
			if (ranArray[l] > ranArray[r]){
				swapping(ranArray, l, r);
			}
			return;
			} else {
				if (ranArray[l] > ranArray[r - 1]){
					swapping(ranArray, l, r - 1);
				}
				
				if (ranArray[l] > ranArray[r]){
					swapping(ranArray, l, r);
				}
				
				if (ranArray[r - 1] > ranArray[r]){
					swapping(ranArray, r - 1, r);
				}
			}
		  } // end of manSort function
} // end of QuickSort class
