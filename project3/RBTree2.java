package project3;

// Course:	CS 3345
// Assignment:	project 3
// Compiler:	Eclipse
// Description:
// This program creates a red and black tree.
 
 // RBNode
 class RBNode
 {
	 // variable declaration
     RBNode left;
     RBNode right;
     int element;
     int color;
 
     // constructor
     public RBNode(int ele){
         this(ele, null, null);
     } // end of constructor
     
     // constructor
     public RBNode(int ele, RBNode l, RBNode n){
         left = l;
         right = n;
         element = ele;
         color = 1;
     } // end of constructor
 } // end of RBNode class
 
 // RBTree2 class
 class RBTree2{
	 // variables declaration
     private RBNode current;
     private RBNode parent;
     private RBNode grand;
     private RBNode great;
     private RBNode header;    
     private static RBNode nullN;
     
     // static initializer for nullN
     static 
     {
         nullN = new RBNode(0);
         nullN.left = nullN;
         nullN.right = nullN;
     }
     
     // assign 1 to black variable, and assign 0 to red variable
     static final int BLACK = 1;    
     static final int RED   = 0;
 
     // constructor
     public RBTree2(int ngIn)
     {
         header = new RBNode(ngIn);
         header.left = nullN;
         header.right = nullN;
     } // end of constructor
     
     // insert method
     public void insert(int inputNode)
     {
    	 // variable declaration and initialization
         current = parent = grand = header;
         nullN.element = inputNode;
         
         while (current.element != inputNode){
        	 great = grand; 
             grand = parent; 
             parent = current;
             
             if(inputNode < current.element){
            	 current = current.left;
             } else {
            	 current = current.right;
             }
             
             // Check if two red children and fix if so            
             if (current.left.color == RED && current.right.color == RED){
            	 reorient(inputNode);
             }
         } // end of while loop
         
         // check if it repeats
         if (current != nullN){
        	 return; 
         }
         
         current = new RBNode(inputNode, nullN, nullN);
         
         // Attach to parent
         if (inputNode < parent.element){
        	 parent.left = current;
         } else {
        	 parent.right = current;    
         }
         
         reorient(inputNode);
     } // end of insert method
     
     private void reorient(int inputNode)
     {
         // flip the color
         current.color = RED;
         current.left.color = BLACK;
         current.right.color = BLACK;
 
         if (parent.color == RED)   
         {
             // rotation
             grand.color = RED;
             
             if (inputNode < grand.element != inputNode < parent.element){
            	 parent = rotate(inputNode, grand);  // Start dbl rotate
             }
             
             current = rotate(inputNode, great);
             current.color = BLACK;
         }
         
         // Make the root's color become black
         header.right.color = BLACK; 
     } // end of reorient method
     
     // rotation method
     private RBNode rotate(int inputNode, RBNode parent){
    	 if(inputNode < parent.element){
    		 return parent.left = inputNode < parent.left.element ? rotateLeftChild(parent.left) : rotateRightChild(parent.left);
    	 } else {
    		 return parent.right = inputNode < parent.right.element ? rotateLeftChild(parent.right) : rotateRightChild(parent.right);
    	 }
     } // end of rotate method
     
     // Rotate binary tree node with left child
     private RBNode rotateLeftChild(RBNode l2)
     {
         RBNode l1 = l2.left;
         l2.left = l1.right;
         l1.right = l2;
         
         return l1;
     } // end of rotateLeftChild method
     
     // Rotate binary tree node with right child
     private RBNode rotateRightChild(RBNode l1)
     {
         RBNode l2 = l1.right;
         l1.right = l2.left;
         l2.left = l1;
         
         return l2;
     } // end of rotateRightChild method
     
     // contains method
     public boolean contains(int value)
     {
         return contains(header.right, value);
     }
     
     // contains method
     private boolean contains(RBNode n, int value)
     {
    	 // Variable declaration
         boolean found = false;
         
         while ((n != nullN) && !found)
         {
        	 // Variable declaration
             int rval = n.element;
             
             if (value < rval){
            	 n = n.left;
             } else if (value > rval){
            	 n = n.right;
             } else {
                 found = true;
                 break;
             }
             
             found = contains(n, value);
         } // end of while loop
         
         return found;
     } // end of contains method
     
     // inorder traversal 
     public void inorder()
     {
         inorder(header.right);
     } // end of inorder method
     
     // inorder traversal
     private void inorder(RBNode n)
     {
         if (n != nullN)
         {
             inorder(n.left);
             
             // print out
             System.out.print(n.element + " ");
             
             inorder(n.right);
         }
     } // end of inorder method
 } // end of RBTree2 class
