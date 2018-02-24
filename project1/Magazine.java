package project1;

// Course:	CS 3345
// Assignment:	project 1
// Compiler:	Eclipse
// Description:
// This program creates basic functions such as the name of the magazine and the name of the publisher of a 
// magazine.

public class Magazine implements Comparable<Magazine>{

	// variables declaration
	int magazineID;
	String magazineName;
	String publisherName;
	
	// constructor
	public Magazine(int id, String mName, String pName){
		this.magazineID = id;
		this.magazineName = mName;
		this.publisherName = pName;
	}
	
	// getter
	public int getMagazineID(){
		return magazineID;
	} // end of getMagazineID method
	
	// getter
	public String getMagazineName(){
		return magazineName;
	} // end of getMagazineName method
	
	// getter
	public String getPublisherName(){
		return publisherName;
	} // end of getPublisherName method
	
	// setter
	public void setMagazineID(int magID){
		magazineID = magID;
	} // end of setMagazineID method
	
	// setter
	public void setMagazineName(String magName){
		magazineName = magName;
	} // end of setMagazineName method
	
	// setter
	public void setPublisherName(String pubName){
		publisherName = pubName;
	} // end of setPublisherName method
	
	public void printMag(){
		// print out
		System.out.println(magazineID);
		System.out.println(magazineName);
		System.out.println(publisherName);
	} // end of printMag method
	
	public int compareTo(Magazine mag)
	{
		// return statement
		return Integer.compare(magazineID, mag.magazineID);
	} // end of compareTo method
} // end of class Magazine
