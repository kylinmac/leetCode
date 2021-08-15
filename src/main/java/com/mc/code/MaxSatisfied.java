package com.mc.code;

import java.util.PriorityQueue;

/**
 * @author macheng
 * @date 2021/2/23 10:34
 */
public class MaxSatisfied {
    public static void main(String[] args) {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;
        System.out.println(new MaxSatisfied().maxSatisfied(customers, grumpy, x));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfiedNum = 0;
        int max = 0;
        int sum=0;
        for (int j = 0; j < customers.length && j < X; j++) {
            if (grumpy[j] == 1) {
                max += customers[j];
            }
        }
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfiedNum += customers[i];
            }

           if (i>0){
               if (grumpy[i-1] == 1){
                   sum-=customers[i-1];
               }
               if (i+X-1<customers.length && grumpy[i+X-1] == 1){
                   sum+=customers[i+X-1];
               }
           }
            if (sum > max) {
                max = sum;
            }
        }
        return satisfiedNum + max;
    }
}
