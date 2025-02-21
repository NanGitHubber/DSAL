package com.ds.al.graph.Ops;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

import com.ds.al.graph.Entity.Graph;

public class GraphOpsImpl implements GraphOps {

	@Override
	public void DFS(Graph g, int v) {
		// TODO Auto-generated method stub

		boolean visited[] = new boolean[g.getVertices()];
		doDfs(1, g.getAdjLst(), visited);
	}

	@Override
	public void BFS(Graph g) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[g.getVertices()];
		doBfs(2, g.getAdjLst(), visited);

	}

	@Override
	public void TopologicalSort(Graph g) {
		// TODO Auto-generated method stub

		boolean visited[] = new boolean[g.getVertices()];
		Stack<Integer> nodeStack = new Stack<Integer>();
		for (int i = 0; i < g.getVertices(); i++) {
			if (!visited[i])
				doTopologicalSort(i, g.getAdjLst(), visited, nodeStack);
		}
		while (!nodeStack.isEmpty()) {
			System.out.println(nodeStack.pop());
		}
	}

	@Override
	public void findUnweightedShortestPath(Graph g, int source) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[g.getVertices()];
		dofindUnweightedShortestPath(source, g.getAdjLst(), visited);
	}

	private void doBfs(int v, LinkedList<Integer> adj[], boolean visited[]) {

		Deque<Integer> nodeQueue = new ArrayDeque<Integer>();
		visited[v] = true;
		nodeQueue.add(v);

		while (!nodeQueue.isEmpty()) {
			int nodeVert = nodeQueue.poll();
			System.out.println("Visited node " + nodeVert);
			ListIterator<Integer> listIterator = adj[nodeVert].listIterator();
			while (listIterator.hasNext()) {
				Integer node = listIterator.next();
				if (!visited[node]) {
					visited[node] = true;
					nodeQueue.add(node);
				}

			}

		}

	}

	private void doDfs(int v, LinkedList<Integer> adj[], boolean visited[]) {

		visited[v] = true;
		System.out.println(v + " ");
		ListIterator<Integer> vertexIterator = adj[v].listIterator();
		while (vertexIterator.hasNext()) {
			int vertex = vertexIterator.next();
			if (!visited[vertex]) {
				doDfs(vertex, adj, visited);
			}
		}

	}

	private void doTopologicalSort(int v, LinkedList<Integer> adj[], boolean visited[], Stack<Integer> nodeTopoStack) {
		visited[v] = true;
		ListIterator<Integer> nodeListIterator = adj[v].listIterator();
		while (nodeListIterator.hasNext()) {
			int nearNode = nodeListIterator.next();
			if (!visited[nearNode])
				doTopologicalSort(nearNode, adj, visited, nodeTopoStack);
		}
		nodeTopoStack.push(v);
	}

	private void dofindUnweightedShortestPath(int source, LinkedList<Integer> adj[], boolean visited[]) {

		int distanceArr[] = new int[adj.length];
		for (int i = 0; i < distanceArr.length; i++)
			distanceArr[i] = -1;
		distanceArr[source] = 0;
		Deque<Integer> nodeQueue = new ArrayDeque<Integer>();
		nodeQueue.push(source);
		while (!nodeQueue.isEmpty()) {
			int popNode = nodeQueue.poll();
			ListIterator<Integer> listIterator = adj[popNode].listIterator();
			while (listIterator.hasNext()) {
				int childNode = listIterator.next();
				if (distanceArr[childNode] == -1) {
					distanceArr[childNode] = distanceArr[popNode] + 1;
					nodeQueue.add(childNode);
				}

			}
		}
	}

}
