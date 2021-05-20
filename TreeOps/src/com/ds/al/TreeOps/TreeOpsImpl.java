package com.ds.al.TreeOps;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static com.ds.al.constants.TreeConstants.NODESEPERATOR;
import com.ds.al.tree.TreeEntity;

public class TreeOpsImpl implements TreeOps {

	private int headIndex;
	private TreeEntity root;
	private int currNodeIndex;
	private boolean found=false;
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

	
	public void getAncestorString(String treeNode,TreeEntity Node,String path) {
		// TODO Auto-generated method stub
		if(root==null||Node==null||found)
		{
			return ;
		}
		if(treeNode.equals(Character.toString(Node.getData())))
		{
			AncestorNodes=path;
			found=true;
			return ;
		}
		path=path+Node.getData()+NODESEPERATOR;
		getAncestorString(treeNode, Node.getLeft(), path);
		getAncestorString(treeNode, Node.getRight(), path);
	}

	@Override
	public String[] getAncestors(String treeNode) {
		// TODO Auto-generated method stub
		String path="";
		String nodes[]=null;
		getAncestorString(treeNode,root, path);
		if(AncestorNodes!=null&&!AncestorNodes.isEmpty())
		{
			nodes=AncestorNodes.split(",");
		}
		
		return nodes;
	}
	
	

	

}
