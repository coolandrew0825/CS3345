package project1;

//Name:			Andrew Chen
//Course:		CS 3345
//Date:			02/14/16
//Assignment:	project 1
//Compiler:		Eclipse
//Description:
//This program creates all the functions listed on menu.

import java.util.NoSuchElementException;
import project1.ListNode;

public class MagazineList {
	
	// variables declaration
	private ListNode nextLink;
	private Magazine data;
	private ListNode head;
	private ListNode tail;
	
	// constructor
	public MagazineList(){
		head = null;
		tail = null;
	} // end of constructor
	
	// empties the linked list
	void makeEmpty(){
		head = null;
		tail = null;
	} // end of makeEmpty method

	Magazine findID(int ID){
		ListNode n = head;
		
		while(n != null){
			if (n.getMagNum().getMagazineID() == ID){
				return n.getMagNum();
			}
			
			n = n.getNextLink();
		} // end of while loop
		
		return null;
	} // end of Magazine method
	
	// insert at front of list
	boolean insertAtFront(Magazine m){
		ListNode newNode = new ListNode(m, head);
		
		head = newNode;

		return true;
	} // end of insertAtFront method
	
	// delete and return the record at the front of the list
	Magazine deleteFromFront(){
		
		// throw a warning if there is no head node
		if (head == null){
			throw new NoSuchElementException();
		}
		
		Magazine newMaga = head.getMagNum();
		head = head.getNextLink();
		
		return newMaga;
	} // end of deleteFromFront method
	
	// find and delete the record with the given ID
	boolean delete(int ID){
		ListNode n = head;
		
		while (n != null)
		{
			if(n.getMagNum().getMagazineID() == ID){
				n.setNextLink(n.getNextLink().getNextLink());
				return true;
			}
			
			n = n.getNextLink();
		} // end of while loop
		
		// return statement
		return false;
	} // end of delete method
	
	boolean printRecord(int ID){
		ListNode n = head;
		
		while(n != null){
			if(n.getMagNum().getMagazineID() == ID){
				n.getMagNum().printMag();
				return true;
			}
			
			n = n.getNextLink();
		} // end of while loop
		
		// return statement
		return false;
	} // end of printRecord method
	
	// print all elements in the order they appear in the linked list
	void printAllRecords(){
		ListNode ln1 = head;
		
		while(ln1 != null){
			ln1.getMagNum().printMag();
			ln1 = ln1.getNextLink();
		} // end of while loop
		
	} //end of printAllRecords method
	
} // end of MagazineList class