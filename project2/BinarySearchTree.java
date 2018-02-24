package project2;

import java.util.Scanner;

// Course:	CS 3345
// Assignment:	project 2
// Compiler:	Eclipse
// Description:
// This program creates a binary search tree, and user can choose the functions listed below to change the tree.

public class BinarySearchTree {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// input scanner
		Scanner input = new Scanner (System.in);
		
		// create an instance of the BinarySearchTree class
		BinarySearchTree bst = new BinarySearchTree();
		
		// variables declaration and initialization
		int option = 0;
		int element = 0;
		int max;
		int min;
		TreeNode currentNode = null;
		boolean containNode;
		int height;
		
		while(true){
			// menu
			System.out.println("Binary Search Trees");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Find Max");
			System.out.println("4. Find Min");
			System.out.println("5. Contains");
			System.out.println("6. In order Tree Traversal");
			System.out.println("7. Height");
			System.out.println("8. No of Nodes");

			// user input
			System.out.print("Your option: ");
			option = input.nextInt();
			
			switch (option){
			case 1:
				// user input
				System.out.print("Enter element: ");
				element = input.nextInt();
				
				while (element < 1 || element >= 100){
					System.out.println("Please enter a number between 1 and 99.");
					System.out.print("Enter element: ");
					element = input.nextInt();
				} // end of while loop
				
					currentNode = bst.insert(element,currentNode);
					
					if(currentNode != null){
						// print out
						System.out.println("Element inserted");
						System.out.println();
						break;
					}
				break;
			case 2:
				// user input
				System.out.print("Enter the element: ");
				element = input.nextInt();
				
				currentNode = bst.delete(element, currentNode);
				
				if(currentNode != null){
					// print out
					System.out.println(element + " was deleted.");
					System.out.println();
				}
				break;
			case 3:
				max = bst.findMax(currentNode);
				// print out
				System.out.println("The maximum element is " + max);
				System.out.println();
				break;
			case 4:
				min = bst.findMin(currentNode);
				// print out
				System.out.println("The minimum element is " + min);
				System.out.println();
				break;
			case 5:
				// user input
				System.out.print("Please enter the element: ");
				element = input.nextInt();
				
				containNode = bst.contains(element, currentNode);
				
				// print out
				if (containNode == true){
					System.out.println("This tree contains the node.");
				} else {
					System.out.println("This tree doesn't contain the node.");
				}
				System.out.println();
				break;
			case 6:
				// print out
				System.out.println("In order Traversal: ");
				bst.InOrderTreeTraversal(currentNode);
				System.out.println();
				break;
			case 7:
				height = bst.height(currentNode);
				
				// print out
				System.out.println("Height = " + height);
				System.out.println();
				break;
			case 8:
				// print out
				int numNode = bst.NoOfNodes(currentNode);
				System.out.println("No Of Nodes: " + numNode);
				//System.out.println("No of Deleted Nodes: ");
				System.out.println();
				break;
			} // end of switch
		} // end of while loop
	} // end of main method

	private static class TreeNode {

		// variables declaration
		int key = 1;
		TreeNode leftChild;
		TreeNode rightChild;
		boolean deleted;
		
		// constructor
		public TreeNode(int key, TreeNode leftChild, TreeNode rightChild){
			this.key = key;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		} // end of constructor
		
		// getter
		public TreeNode getLeftChild() {
			return leftChild;
		} // end of getLeftChild method
		
		// getter
		public TreeNode getRightChild() {
			return rightChild;
		} // end of getRightChild method
		
		// setter
		public void setLeftChild(TreeNode leftChild){
			this.leftChild = leftChild;
		} // end of setLeftChild method
		
		// setter
		public void setRightChild(TreeNode rightChild){
			this.rightChild = rightChild;
		} // end of setRightChild method
		
		// print out the Binary Search tree
		public void printTree(){
			// print out
			if (this != null) {
				if (this.getLeftChild() != null){
					this.getLeftChild().printTree();
				}
			
				// print out
				if(this.deleted){
					System.out.print(" *");
				}
				// print out
				System.out.print(this.key + " ");
			
				if (this.getRightChild() != null){
					this.getRightChild().printTree();
				}
			}
		} // end of printTree Method
	} // end of public class TreeNode
	
	// variables declaration
	int x = 0;
	private TreeNode lt;
	private TreeNode rt;
	private TreeNode root;
	int compareResult;
	
	// constructor
	public BinarySearchTree() {
		root = null;
	} // end of constructor

	// insert method
	TreeNode insert(int x, TreeNode root) {
		
		if(root == null){
			return new TreeNode(x, null, null);	
		}
		
		if (x < root.key) compareResult = -1;
		else if (x > root.key) compareResult = 1;
		else compareResult = 0;
		
		if(compareResult < 0){
			root.leftChild = insert(x,root.leftChild);
		} else if (compareResult > 0){
			root.rightChild = insert(x, root.rightChild);
		} else {
			;
		}
		
		// return statement
		return root;
	} // end of insert method
	
	// delete method
	TreeNode delete(int x, TreeNode currentNode) {
		
		boolean yn = contains(x, currentNode);
		
		if (yn == true){
			
			if (currentNode == null){
				return currentNode;
			}
			
			if (x < currentNode.key) compareResult = -1;
			else if (x > currentNode.key) compareResult = 1;
			else compareResult = 0;
			
			if (compareResult < 0){
				currentNode.leftChild = delete(x, currentNode.leftChild);
			} else if (compareResult > 0){
				currentNode.rightChild = delete(x, currentNode.rightChild);
			} else if (currentNode.leftChild != null && currentNode.rightChild != null){
				currentNode.key =findMin(currentNode.rightChild);//.key
				currentNode.rightChild = delete(currentNode.key, currentNode.rightChild);
			} else {
				currentNode = (currentNode.leftChild != null) ? currentNode.leftChild : currentNode.rightChild;
			}
			
			// return statement
			return currentNode;
		} else {
			// print out
			System.out.println("This node doesn't exist in the tree.");
		}
		// return statement
		return null;
	} // end of delete method
	
	// findMin method
	int findMin(TreeNode currentNode) {
		if(currentNode == null){
			return 0;
		} else if (currentNode.leftChild == null){
			return currentNode.key;
		}
		
		// return statement
		return findMin(currentNode.leftChild);
	} // end of findMin method
	
	// findMax method
	int findMax(TreeNode currentNode) {
		if (currentNode != null){
			while(currentNode.rightChild != null){
				currentNode = currentNode.rightChild;
			} // end of while loop
		}
		
		// return statement
		return currentNode.key;
	} // end of findMax method
	
	// contains method
	boolean contains(int x, TreeNode currentNode) {
		if (currentNode == null){
			return false;
		}
		
		if (x < currentNode.key){
			compareResult = -1;
		} else if (x > currentNode.key){
			compareResult = 1;
		} else {
			compareResult = 0;
		}
		
		if(compareResult < 0){
			return contains(x, currentNode.leftChild);
		} else if (compareResult > 0){
			return contains(x, currentNode.rightChild);
		} else {
			return true; // Match
		}
	} // end of contains method
	
	// print the binary search tree in order
	void InOrderTreeTraversal(TreeNode currentNode) {
		currentNode.printTree();
	} // end of InOrderTreeTraversal method
	
	// print out the height of the binary search tree
	int height(TreeNode currentNode) {
		
		// variables declaration
		int leftH;
		int rightH;
		
		if(currentNode == null){
			return -1;
		}
		
		// variables declaration and initialization
		leftH = height(currentNode.leftChild);
		rightH = height(currentNode.rightChild);
		
		if (leftH > rightH){
			return leftH + 1;
		} else {
			return rightH + 1;
		}
	} // end of height method
	
	// return number of nodes
	int NoOfNodes(TreeNode currentNode) {
		if (currentNode == null){
			return 0;
		}
		
		return 1 + NoOfNodes(currentNode.leftChild) + NoOfNodes(currentNode.rightChild);
	} // end of NoOfNodes method
} // end of class method
