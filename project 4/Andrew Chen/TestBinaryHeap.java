package project4;

// Name:		Andrew Chen
// Course:		CS 3345
// Date:		03/27/16
// Assignment:	project 4
// Compiler:	Eclipse
// Description:
// User will run this program to create an user interface. Only the first option out of the six options does not work.

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

class BinaryHeap {
	// variable declaration and initialization
	private static final int y = 2;
	private int sizeOfHeap;
	private int[] heap1;
	
	// constructor
	public BinaryHeap(int capa){
		sizeOfHeap = 0;
		heap1 = new int[capa + 1];
		Arrays.fill(heap1, -1);
	} // end of constructor
	
	// clear heap1
	public void makeEmpty(){
		sizeOfHeap = 0;
	} // end of makeEmpty method
	
	// check if heap1 is full
	public boolean isFull(){
		// return statement
		return sizeOfHeap == heap1.length;
	} // end of isFull method
	
	// check if heap1 is empty
	public boolean isEmpty(){
		// return statement
		return sizeOfHeap == 0;
	} // end of isEmpty method
	
	// get the index parent of x
	private int parent(int x){
		return (x-1)/y;
	} // end of parent method
	
	// get index of kth chi of x
	private int theZthChild(int x, int a){
		// return statement
		return y * x + a;
	} // end of theZthChild
	
	// insert element
	public void insert(int x){
		if(isFull()){
			throw new NoSuchElementException("Overflow Exception");
		}
		
		// percolate up
		heap1[sizeOfHeap++] = x;
		heapUp(sizeOfHeap - 1);
	} // end of insert method
	
	// find the smallest element
	public int findMin(){
		if(isEmpty()){
			throw new NoSuchElementException("Underflow Exception");
		}
		// return statement
		return heap1[0];
	} // end of findMin method
	
	// delete the minimum element
	public int deleteMin(){
		// variable declaration and initialization
		int key = heap1[0];
		
		// calling delete method
		delete(0);
		
		// return statement
		return key;
	} // end of deleteMin method
	
	// delete an element at its index
	public int delete(int individual){
		if(isEmpty()){
			throw new NoSuchElementException("Underflow Exception");
		}
		
		// variable declaration and initialization
		int key = heap1[individual];
		
		heap1[individual] = heap1[sizeOfHeap - 1];
		sizeOfHeap--;
		heapDown(individual);
		
		// return statement
		return key;
	} // end of delete method
	
	
	private void heapUp(int childInd){
		// variable declaration and initialization
		int tmp = heap1[childInd];
		
		while(childInd > 0 && tmp < heap1[parent(childInd)]){
			heap1[childInd] = heap1[parent(childInd)];
			childInd = parent(childInd);
		} // end of while loop
		
		heap1[childInd] = tmp;
	} // end of heapUp method
	
	private void heapDown(int individual){
		// variable declaration and initialization
		int chi;
		int tmp = heap1[individual];
		
		while(theZthChild(individual,1) < sizeOfHeap){
			chi = minChild(individual);
			if(heap1[chi] < tmp){
				heap1[individual] = heap1[chi];
			} else {
				break;
			}
			individual = chi;
		} // end of while loop
		heap1[individual] = tmp;
	} // end of heapDown method
	
	// get smallest child
	private int minChild(int individual){
		// variable declaration and initialization
		int bestChi = theZthChild(individual, 1);
		int a = 2;
		int pos = theZthChild(individual,a);
		
		while((a <= y) && (pos < sizeOfHeap)){
			if (heap1[pos] < heap1[bestChi]){
				bestChi = pos;
			}
			pos = theZthChild(individual, a++);
		} // end of while loop
		
		// return statement
		return bestChi;
	} // end of minChild method
	
	// print the heap1
	public void printArray(){
		// print out
		System.out.print("Array = ");
		
		for(int count = 0; count < sizeOfHeap; count++){
			System.out.print(heap1[count] + " ");
		} // end of for loop
		
		// print out
		System.out.println();
	} // end of printArray method
} // end of BinaryHeap class

public class TestBinaryHeap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// input scanner
		Scanner input = new Scanner(System.in);
		
		// variable declaration and initialization
		char ch = 'n';
		int size = 0;
		// input
		System.out.print("Enter the size: ");
		size = input.nextInt();
		// create object
		BinaryHeap biHeap = new BinaryHeap(size);
		
		System.out.println();
		
		do{
			// menu
			System.out.println("1. Add Event");
			System.out.println("2. insert");
			System.out.println("3. Print Array");
			System.out.println("4. Build Heap");
			System.out.println("5. Delete Min");
			System.out.println("6. Quit");
			System.out.println();
			
			// user input
			System.out.print("Option: ");
			int choice = input.nextInt();
			
			switch(choice){
			case 1:
				break;
			case 2:
				try{
					// user input
					System.out.print("Enter an integer: ");
					biHeap.insert(input.nextInt());
					System.out.println();
				} catch (Exception e){
					// print out
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				// display heap1
				biHeap.printArray();
				System.out.println();
				break;
			case 4:
				// print out
				System.out.println("The heap is built successfully.");
				System.out.println();
				break;
			case 5:
				try{
					// user input
					System.out.println("Minimum element = " + biHeap.deleteMin());
					System.out.println("Minimum element is deleted.");
					System.out.println();
				} catch (Exception e) {
					// print out
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				// user input
				System.out.print("Are you sure? (Type y or no)");
				ch = input.next().charAt(0);
				break;
			default:
				// print out
				System.out.println("Wrong Entry\n");
				break;
			} // end of switch
		} while (ch == 'N' || ch == 'n'); // end of do while loop
	} // end of main method
} // end of TestBinaryHeap class