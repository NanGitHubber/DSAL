package com.ds.al.BinarySearch.TreeStarter;

import java.util.ArrayList;
import java.util.Scanner;

import com.ds.al.BinarySearch.TreeEntity.BinarySearchTreeEntity;
import com.ds.al.BinarySearch.TreeOps.TreeOps;
import com.ds.al.BinarySearch.TreeOps.TreeOpsImpl;
import com.ds.al.DoubleLinkedLstEntity.DoubleLinkedLst;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 0, rank = 0, nodeData, sizeTwo = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of BST one");
//		DoubleLinkedLst head = null;
//		System.out.println("Enter the size of the Double Linked List");
		size = sc.nextInt();
		String bstString = "";
		String bstStringTwo = "";
//		String bstNode = "";
//		String bstNodeFirst = "";
//		String bstNodeSecond = "";
		System.out.println("Enter data for BST one");
		for (int i = 0; i < size; i++)
			bstString = bstString + sc.next() + ",";
		String[] bstnodes = bstString.split(",");
		TreeOps operation = new TreeOpsImpl();
		BinarySearchTreeEntity createBSTone = operation.createBST(bstnodes);
		DoubleLinkedLst dllNode = operation.convertBST2DLL(createBSTone);
		System.out.println("Enter the size of the BST Two");
		sizeTwo = sc.nextInt();
		System.out.println("Enter data for BST two");
		for (int i = 0; i < sizeTwo; i++)
			bstStringTwo = bstStringTwo + sc.next() + ",";
		String[] bstNodesTwo = bstStringTwo.split(",");
		TreeOps operationTwo = new TreeOpsImpl();
		BinarySearchTreeEntity createBSTTwo = operationTwo.createBST(bstNodesTwo);
		DoubleLinkedLst dllNodeSecond = operationTwo.convertBST2DLL(createBSTTwo);
		TreeOps ops = new TreeOpsImpl();
		ArrayList<String> nodeLst = new ArrayList<>();
		ops.findIntersectionOptimized(dllNode, dllNodeSecond, nodeLst);

		/*
		 * System.out.println("Enter the node data "); nodeData = sc.nextInt();
		 * operation.findFloorNode(nodeData);
		 */
		// operation.findCeilNode(nodeData);

//		TreeOps operation = new TreeOpsImpl();
//		operation.createBST(bstString);
//		System.out.println("Enter the node data ");
//		nodeData = sc.nextInt();
//		operation.findCeilNode(nodeData);
		/*
		 * System.out.println("Enter the rank"); rank=sc.nextInt();
		 * operation.findKthSmallestNode(rank);
		 */
//		operation.convertBST2CDLL();
//		System.out.println("Enter Sorted data for the Lst");
//		DoubleLinkedLst prev = null;
//		for (int i = 0; i < size; i++) {
//			if (head == null) {
//				head = new DoubleLinkedLst();
//				head.setData(sc.next());
//				head.setNxt(null);
//				head.setPrev(null);
//				prev = head;
//			} else {
//				DoubleLinkedLst node = new DoubleLinkedLst();
//				node.setData(sc.next());
//				node.setPrev(prev);
//				node.setNxt(null);
//				prev.setNxt(node);
//				prev = node;
//			}
//		}
//		operation.convertDLL2BSTOptimized(head);
		// operation.convertDLL2BST(head);
		/*
		 * System.out.println("Enter the first BST Node"); bstNodeFirst=sc.next();
		 * System.out.println("Enter the second BST Node"); bstNodeSecond=sc.next();
		 * 
		 * 
		 * //operation.findShortestPath(bstNodeFirst, bstNodeSecond); /*
		 * System.out.println("Enter the node to search"); bstNode = sc.next();
		 * operation.findNode(bstNode);
		 */
		// operation.findMinimumNode();
		// operation.findMaximumNode();
		sc.close();

	}

}
