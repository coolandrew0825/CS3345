package project1;

// Name:	Andrew Chen
// Course:	CS 3345
// Assignment:	project 1
// Compiler:	Eclipse
// Description:
// This program creates listed node.

public class ListNode {

	 // variables declaration
	private Magazine magNum;
	private ListNode nextLink;
	
	// constructor
	public ListNode(Magazine magNum, ListNode nextLink){
		super();
		this.magNum = magNum;
		this.nextLink = nextLink;
	} // end of constructor
	
	// getter
	public Magazine getMagNum() {
		return magNum;
	} // end of getData method
	
	// setter
	public void setMagNum(Magazine magNum) {
		this.magNum = magNum;
	} // end of setData method
	
	// getter
	public ListNode getNextLink() {
		return nextLink;
	} // end of getNextLink method
	
	// setter
	public void setNextLink(ListNode nextLink) {
		this.nextLink = nextLink;
	} // end of setNextLink method
} // end of class ListNode
