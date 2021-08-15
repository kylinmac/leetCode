package com.mc.code;

/**
 * @author macheng
 * @date 2021/3/24 9:13
 */
public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        int[] mins=new int[nums.length];
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<min){
                min=nums[i];
            }
            mins[i]=min;
        }

        for (int i = nums.length-1; i >=0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>mins[j] && mins[j]<nums[j] && nums[j]>nums[i]){
                    return true;
                }
            }
        }

        return false;

    }
}
