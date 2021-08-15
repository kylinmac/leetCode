package com.mc.code;

/**
 * @author macheng
 * @date 2021/2/7 23:02
 */
public class FeidijianArray {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4,2,1}));
    }

    public static boolean checkPossibility(int[] nums) {


        int sum=0;

        for(int i=1;i<nums.length-1;i++){
            if(nums[i]<nums[i-1]){
                sum++;

                nums[i]= nums[i-1];

                i--;
            }
            if(sum >= 2){
                return false;
            }
        }

        return true;
    }
}
