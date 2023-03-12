package com.ds.al.GreedyStarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.ds.al.GreedyEntity.HuffmanNode;
import com.ds.al.GreedyEntity.TrainObj;
import com.ds.al.GreedyOps.GreedyOps;
import com.ds.al.GreedyOps.GreedyOpsImpl;
import com.ds.al.GreedyUtil.HuffmanNodeComparator;

public class GreedyStarter {

	public static void main(String[] args) {
		int size;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of trains");
		size = sc.nextInt();
		ArrayList<TrainObj> trainLst = new ArrayList<TrainObj>();
		String name;
		double arrivingTime;
		double departureTime;
		for (int i = 0; i < size; i++) {
			TrainObj train = new TrainObj();
			System.out.println("Enter the Train Name");
			name = sc.next();
			train.setTrainName(name);
			System.out.println("Enter the arrival time");
			arrivingTime = sc.nextDouble();
			train.setArrivalTime(arrivingTime);
			System.out.println("Enter the departure time");
			departureTime = sc.nextDouble();
			train.setDepartureTime(departureTime);
			trainLst.add(train);

		}
         GreedyOps ops=new GreedyOpsImpl();
         System.out.println(ops.getPlatformNeeded(trainLst));
		sc.close();

	}

}
