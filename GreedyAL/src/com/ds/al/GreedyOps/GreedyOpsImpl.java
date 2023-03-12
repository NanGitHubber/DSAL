package com.ds.al.GreedyOps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import com.ds.al.GreedyEntity.HuffmanNode;
import com.ds.al.GreedyEntity.TrainObj;
import com.ds.al.GreedyUtil.TrainArrTimeComp;
import com.ds.al.GreedyUtil.TrainDepartureTime;

public class GreedyOpsImpl implements GreedyOps {

	@Override
	public HuffmanNode createHuffmanTree(PriorityQueue<HuffmanNode> huffmanNodeQueue) {
		// TODO Auto-generated method stub'
		HuffmanNode newNode = null;
		while (huffmanNodeQueue.size() > 1) {
			HuffmanNode pollNodeMinOne = huffmanNodeQueue.peek();
			huffmanNodeQueue.poll();
			HuffmanNode pollNodeMinTwo = huffmanNodeQueue.peek();
			huffmanNodeQueue.poll();
			newNode = new HuffmanNode();
			newNode.sethuffmanChar('-');
			newNode.setData(pollNodeMinOne.getData() + pollNodeMinTwo.getData());
			newNode.setLeft(pollNodeMinOne);
			newNode.setRight(pollNodeMinTwo);
			huffmanNodeQueue.add(newNode);

		}
		return newNode;
	}

	private boolean isLeafNode(HuffmanNode node) {
		if (node.getLeft() == null && node.getRight() == null) {
			return true;
		}
		return false;
	}

	@Override
	public void printHuffmanCode(HuffmanNode root, HashMap<Integer, String> codeMap, String code, Boolean isLeft) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if(isLeft!=null)
		{
		if (isLeft)
			code = code + "0";
		else
			code = code + "1";
		}

		if (isLeafNode(root)) {

			int huffmanChar = (int) root.gethuffmanChar();
			codeMap.put(huffmanChar, code);
		}
		printHuffmanCode(root.getLeft(), codeMap, code,true);
		printHuffmanCode(root.getRight(), codeMap, code,false);

	}

	@Override
	public int getPlatformNeeded(ArrayList<TrainObj> trainLst) {
		// TODO Auto-generated method stub
		int platCount=0;
		PriorityQueue<TrainObj> arrivalTimeQueue=new PriorityQueue<TrainObj>(new TrainArrTimeComp());
		PriorityQueue<TrainObj> departureTeamQueue=new PriorityQueue<TrainObj>(new TrainDepartureTime());
		for(TrainObj tr:trainLst)
		{
		arrivalTimeQueue.add(tr);
		departureTeamQueue.add(tr);
		}
		while(!arrivalTimeQueue.isEmpty()&&!departureTeamQueue.isEmpty())
		{
			TrainObj arr = arrivalTimeQueue.peek();
		    TrainObj depar = departureTeamQueue.peek();
		    if(arr.getArrivalTime() < depar.getDepartureTime())
		      platCount++;
		    else
		    	departureTeamQueue.poll();
		    
		     arrivalTimeQueue.poll();
		    
		    
		    
		}
		
		return platCount;
	}

}
