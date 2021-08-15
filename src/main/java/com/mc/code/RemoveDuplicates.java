package com.mc.code;

/**
 * @author macheng
 * @date 2021/4/6 10:49
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums ){
        int tiqian=0;
        for (int i = 1; i < nums.length; i++) {
            nums[i-tiqian]=nums[i];
            if (nums[i]==nums[i-1]){
                tiqian++;
            }

        }

        return nums.length-tiqian;
    }
}
