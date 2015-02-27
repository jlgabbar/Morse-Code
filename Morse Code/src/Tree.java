/* 
     Name: Joseph Gabbard 
     Email: jlgabbar@go.olemiss.edu 
     Program Source File Name: Tree.java 
     Current Date: 2-17-14
     Course Information: CSCI 433 Section1
     Instructor: Dr. Wilkins
     Program Description: Converts Morse Code to English and vice versa.
     					  Builds a tree and gives the proper traversals
     
     Honor Code Statement: In keeping with the honor code policies of the University of Mississippi, the School of Engineering,      and the Department of Computer and Information Science, I affirm that I have neither given nor received assistance on this      programming assignment. This assignment represents my individual, original effort. 
                    ... My Signature is on File. 
*/ 

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class Tree {
	class Node {
		Node left;
		Node right;
		String data;

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}

		public String getData() {
			return this.data;
		}
	}

	Node root = new Node();
	Node temp = new Node();
	int numE2M;
	int numM2E;
	HashMap<Character, String> hm = new HashMap<Character, String>();

	public Tree(String file) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(file));
		root.data = " ";
		Node position = new Node();
		while (scan.hasNextLine()) {
			position = root;
			String line = scan.nextLine();
			String morse = line.substring(1);
			char var = line.charAt(0);
			char lastvar = line.charAt(line.length() - 1);
			hm.put(var, line.substring(1));
			for (int i = 0; i < morse.length() - 1; i++) {
				if (morse.substring(i, i + 1).equals(".")) {
					position = position.left;
				} else
					position = position.right;
			}
			if (lastvar == '.') {
				Node n = new Node();
				position.left = n;
				n.data = Character.toString(var);
			} else {
				Node n = new Node();
				position.right = n;
				n.data = Character.toString(var);

			}
		}

	}

	public void inOrder() {
		System.out.print("Inorder:   ");
		inOrder(root);
	}

	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData());
			inOrder(root.getRight());
		}

	}

	public void preOrder() {
		System.out.print("Preorder:  ");
		preOrder(root);
	}

	public void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data);
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	public void postOrder() {
		System.out.print("Postorder: ");
		postOrder(root);
		System.out.println();
	}

	public void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.data);
	}

	public void translate(String file2) throws FileNotFoundException {
		Scanner scan2 = new Scanner(new File(file2));
		numE2M = scan2.nextInt();
		numM2E = scan2.nextInt();
		System.out.println("English to Morse translations:");
		scan2.nextLine();
		for (int i = 0; i < numE2M; i++) {
			String line = scan2.nextLine();
			System.out.println("English Phrase: " + line);
			System.out.print("Morse Phrase:  ");
			String split[] = line.split("\\s");
			for (int j = 0; j < split.length; j++) {
				String word = split[j];
				for (int k = 0; k < word.length(); k++) {
					System.out.print(hm.get(word.charAt(k)));
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Morse to English translations:");
		for (int i = 0; i < numM2E; i++) {
			String line2 = scan2.nextLine();
			System.out.println("Morse Phrase: " + line2);
			String[] split2 = line2.split("\\s");
			System.out.print("English Phrase: ");
			for (int j = 0; j < split2.length; j++) {
				temp = root;
				String word2 = split2[j];
				for(int k =0;k<word2.length();k++)
					if (word2.charAt(k)=='.') {
						temp = temp.left;
					} else {
						temp = temp.right;
					}
					System.out.print(temp.data);
				
			}
			System.out.println();
		}
	}
}
