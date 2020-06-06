package com.ds.al.traversal;

import com.ds.al.entity.TreeEntity;

public interface TraversalOps {

	public void PreorderTraversal(TreeEntity root);

	public void InorderTravsersal(TreeEntity root);

	public int MaxTreeElement(TreeEntity root);

	public int MaxTreeElementIterative(TreeEntity root);
	
	public boolean SearchTreeElement(TreeEntity root,int data);
	public boolean SearchTreeElementIterative(TreeEntity root,int data);

}
