package com.ds.al.Generic.TreeStarter;

import java.util.Scanner;

import com.ds.al.Generic.TreeEntity.GenericTreeEntity;
import com.ds.al.Generic.TreeOps.TreeOps;
import com.ds.al.Generic.TreeOps.TreeOpsImpl;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// GenericTreeEntity root;
		// String inorderSequence = "", preOrderSequence = "";
		Scanner sc = new Scanner(System.in);
		int treeSize;
		TreeOps ops = new TreeOpsImpl();
		System.out.println("Enter the tree size");
		treeSize = sc.nextInt();
		int parentArr[] = new int[treeSize];
		System.out.println("Enter the tree elements of the parent array");
		for (int i = 0; i < treeSize; i++) {
			parentArr[i] = sc.nextInt();

		}
		System.out.println("Depth of generic Tree is " + ops.getDepth(parentArr));

		// System.out.println("Enter the preOrder Sequence ");
		/*
		 * for (int i = 0; i < treeSize; i++) { preOrderSequence = preOrderSequence +
		 * sc.next() + ""; } System.out.println("Enter the inorder Sequence"); for (int
		 * i = 0; i < treeSize; i++) { inorderSequence = inorderSequence + sc.next() +
		 * ""; }
		 */
		// root = ops.mkGenericTree(preOrderSequence, inorderSequence);
		// System.out.println("inorder traversal string ");
		// ops.TreeTraversal(root);
		// System.out.println("sum of all nodes is"+ops.getNodeSum(root));
		sc.close();

	}

}
