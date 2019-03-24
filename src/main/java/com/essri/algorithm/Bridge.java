package com.essri.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 프로그래머스 / 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class Bridge {
    private int bridge_length;
    private int weight;
    private int[] truck_weights;

    public Bridge(int bridge_length, int weight, int[] truck_weights){
        this.bridge_length = bridge_length;
        this.weight = weight;
        this.truck_weights = truck_weights;
    }


    public int solution() {
        int answer = 0;
        Queue<Truck> waitList = new LinkedList<>();
        List<Truck> bridge = new ArrayList<>();
        Truck truck;

        for (int t : truck_weights) {
            waitList.add(new Truck(t, bridge_length));
        }

        while(!(waitList.isEmpty() && bridge.isEmpty())) {
            answer++;

            if (!bridge.isEmpty() && bridge.get(0).distance <= 0) {
                weight += bridge.get(0).weight;
                bridge.remove(0);
            }

            if (!waitList.isEmpty() && weight - waitList.peek().weight >= 0) {
                weight -= waitList.peek().weight;
                bridge.add(waitList.poll());
            }

            for (int i = 0; i < bridge.size(); i++) {
                truck = bridge.get(i);
                truck.distance--;
            }
        }

        return answer;
    }

    class Truck {
        int distance;
        int weight;

        public Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }
}
