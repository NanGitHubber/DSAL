package com.ds.al.TreeOps;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static com.ds.al.constants.TreeConstants.NODESEPERATOR;

import com.ds.al.TreeUtility.QueueEntity;
import com.ds.al.tree.TreeEntity;

public class TreeOpsImpl implements TreeOps {

	private int headIndex;
	private TreeEntity root;
	private int currNodeIndex;
	private boolean found = false;
	private String AncestorNodes;

	private void getCreateTree(String inorderSubStr, String preOrderSequence, TreeEntity root, int index,
			TreeEntity head, String inOrderSequence) {
		// TODO Auto-generated method stub

		if (index > preOrderSequence.length() || inorderSubStr == null || inorderSubStr.isEmpty())
			return;
		boolean isLeft;
		String preOrderNode = Character.toString(preOrderSequence.charAt(index));
		int nodeIndex = inOrderSequence.indexOf(preOrderNode);
		if (nodeIndex > headIndex)
			isLeft = FALSE;
		else
			isLeft = TRUE;
		head = createTreeNode(root, head, preOrderNode, isLeft);
		headIndex = nodeIndex;
		currNodeIndex++;
		String leftSequence = "";
		int splitIndex = inorderSubStr.indexOf(preOrderNode);
		if (splitIndex + 1 <= inorderSubStr.length())
			leftSequence = inorderSubStr.substring(0, splitIndex);
		String rightSequence = "";
		if (splitIndex + 1 < inorderSubStr.length())
			rightSequence = inorderSubStr.substring(splitIndex + 1, inorderSubStr.length());
		getCreateTree(leftSequence, preOrderSequence, this.root, currNodeIndex, head, inOrderSequence);
		getCreateTree(rightSequence, preOrderSequence, this.root, currNodeIndex, head, inOrderSequence);

	}

	private TreeEntity createTreeNode(TreeEntity root, TreeEntity head, String data, boolean isLeft) {
		if (root == null) {
			root = new TreeEntity();
			root.setData(data.charAt(0));
			root.setLeft(null);
			root.setRight(null);
			head = root;
			this.root = root;

		} else {
			TreeEntity node = new TreeEntity();
			node.setData(data.charAt(0));
			node.setLeft(null);
			node.setRight(null);
			if (isLeft)
				head.setLeft(node);
			else
				head.setRight(node);
			head = node;
		}
		return head;
	}

	@Override
	public TreeEntity getCreateTreeInorderPreorder(String inorderSequence, String preOrderSequence) {
		// TODO Auto-generated method stub
		getCreateTree(inorderSequence, preOrderSequence, null, 0, null, inorderSequence);

		return this.root;
	}

	public void getAncestorString(String treeNode, TreeEntity Node, String path) {
		// TODO Auto-generated method stub
		if (root == null || Node == null || found) {
			return;
		}
		if (treeNode.equals(Character.toString(Node.getData()))) {
			AncestorNodes = path;
			found = true;
			return;
		}
		path = path + Node.getData() + NODESEPERATOR;
		getAncestorString(treeNode, Node.getLeft(), path);
		getAncestorString(treeNode, Node.getRight(), path);
	}

	@Override
	public String[] getAncestors(String treeNode) {
		// TODO Auto-generated method stub
		String path = "";
		found = false;
		AncestorNodes = "";
		String nodes[] = null;
		getAncestorString(treeNode, root, path);
		if (AncestorNodes != null && !AncestorNodes.isEmpty()) {
			nodes = AncestorNodes.split(",");
		}

		return nodes;
	}

	@Override
	public String getLCA(String treeNode1, String treeNode2) {
		// TODO Auto-generated method stub
		String lcaNode = null;
		String ancestralNodes1[] = getAncestors(treeNode1);
		String ancestralNodes2[] = getAncestors(treeNode2);
		if (ancestralNodes1 != null && ancestralNodes2 != null && ancestralNodes1.length > 0
				&& ancestralNodes2.length > 0) {
			int commonPathLen = (ancestralNodes1.length > ancestralNodes2.length) ? ancestralNodes2.length
					: ancestralNodes1.length;
			for (int i = 0; i < commonPathLen; i++) {
				if (ancestralNodes1[i].equals(ancestralNodes2[i])) {
					lcaNode = ancestralNodes1[i];
				}
			}
		}

		return lcaNode;
	}

	public void zigZagTraversal() throws Exception {
		QueueEntity queue = new QueueEntity();
		queue.Enqueue(root);
		queue.Enqueue(null);
		TreeEntity treeNode;
		String zigZagStr="";
		while (!queue.isEmpty()) {
			treeNode = queue.Dequeue();
			
			if (treeNode == null) {
				queue.Enqueue(null);
			zigZagStr=zigZagStr+",";
			}
			else
			{
				zigZagStr=zigZagStr+treeNode.getData();
			if (treeNode.getLeft() != null)
				queue.Enqueue(treeNode.getLeft());
			if (treeNode.getRight() != null)
				queue.Enqueue(treeNode.getRight());
			}
		}
	}

}
