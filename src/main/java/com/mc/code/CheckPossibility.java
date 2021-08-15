package com.mc.code;

/**
 * @author macheng
 * @date 2021/3/10 19:31
 */
public class CheckPossibility {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
    }

    public static boolean checkPossibility(int[] nums) {

        if (nums.length < 3) {
            return true;
        }
        int sum = 0;
        if (nums[0]>nums[1]){
            sum++;
        }
        for (int i = 1; i < nums.length - 2; i++) {
            if (nums[i] > nums[i + 1]) {
                if ((nums[i] >= nums[i - 1] && nums[i] <= nums[i + 2]) || (nums[i + 1] >= nums[i - 1] && nums[i + 1] <= nums[i + 2])) {
                    sum++;
                } else {
                    return false;
                }
                if (sum == 2) {
                    return false;
                }
            }
        }
        if (sum==1 && nums[nums.length-2]>nums[nums.length-1]){
            return false;
        }

        return true;
    }

}
