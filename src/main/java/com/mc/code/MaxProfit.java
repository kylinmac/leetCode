package com.mc.code;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author macheng
 * @date 2020/12/28 9:05
 */
public class MaxProfit {


    public static void main(String[] args) {

        int[] ints=new int[]{1,5,2,7,9};
        System.out.println(maxProfit(2,ints));
    }
    public static int maxProfit(int k, int[] prices) {
        int length = prices.length;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(length / 2, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return (x < y) ? 1 : ((x == y) ? 0 : -1);
            }
        });

        int cur = prices[0];
        boolean buyFlag = true;
        int sell = prices[0];
        for (int i = 0; i < length; i++) {
            if (buyFlag && cur > prices[i]) {
                cur = prices[i];
                sell = prices[i];
            }

            if (sell < prices[i]) {
                buyFlag = !buyFlag;
                sell = prices[i];
            }
            if (sell > prices[i]) {
                buyFlag = !buyFlag;
                priorityQueue.add(sell - cur);
                cur = prices[i];
                sell = prices[i];
            }
            if (i==length-1 ){
                priorityQueue.add(sell - cur);
            }

        }


        int result = 0;
            for (int i = 0; i < k && priorityQueue.peek() != null; i++) {
                Integer poll = priorityQueue.poll();
                result += poll;
            }


        return result;

    }

}
