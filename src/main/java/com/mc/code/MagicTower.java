package com.mc.code;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author macheng
 * @date 2021/4/6 15:48
 */
@Data
@Builder
public class MagicTower<T> {


    private String s;
    private String m;

    public static int magicTower(int[] nums) {
        MagicTower build = MagicTower.builder().s("1").m("2").build();



        PriorityQueue<int[]> min=new PriorityQueue<>(nums.length,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int sum=0;
        int num=0;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]<0){
                min.add(new int[]{nums[i],i});
            }
            sum+=nums[i];
            if (sum>=0){
                continue;
            }else {
                num++;
                int[] poll = min.poll();
                int last = nums[nums.length - 1];
                sum=sum-poll[0]+last;
                if (sum<0){
                    return -1;
                }
            }

        }

        if (sum<0){
            return -1;
        }
        return num;
    }

    public static void main(String[] args) {
        Integer integer = new Integer(1);
        Integer integers = new Integer(1);
        // magicTower(new int[]{-200,-300,400,0});
        System.out.println(Integer.toBinaryString(31));
        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(9999));
    }
}
