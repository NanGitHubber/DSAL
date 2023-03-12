package com.ds.al.GreedyUtil;

import java.util.Comparator;

import com.ds.al.GreedyEntity.TrainObj;

public class TrainDepartureTime  implements Comparator<TrainObj>{

	@Override
	public int compare(TrainObj o1, TrainObj o2) {
		int diff;
		diff=(o1.getDepartureTime()==o2.getDepartureTime())?0:(o1.getDepartureTime() >o2.getDepartureTime())?1:-1;
		return diff;
	}

}
