package com.ds.al.GreedyUtil;

import java.util.Comparator;

import com.ds.al.GreedyEntity.TrainObj;

public class TrainArrTimeComp implements Comparator<TrainObj>{

	@Override
	public int compare(TrainObj o1, TrainObj o2) {
		// TODO Auto-generated method stub
		int diff;
		diff=(o1.getArrivalTime()==o2.getArrivalTime())?0:(o1.getArrivalTime() >o2.getArrivalTime())?1:-1;
		return diff;
	}

}
