package com.ds.al.GreedyOps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import com.ds.al.GreedyEntity.HuffmanNode;
import com.ds.al.GreedyEntity.TrainObj;

public interface GreedyOps {

	
	public HuffmanNode createHuffmanTree(PriorityQueue<HuffmanNode> huffmanNodeQueue);
	
	public void printHuffmanCode(HuffmanNode root,HashMap<Integer, String> codeMap,String code,Boolean isLeft);
	
	public int getPlatformNeeded(ArrayList<TrainObj> trainLst);
	
	
}
