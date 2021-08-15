package com.mc.code;

import java.util.Arrays;

/**
 * @author macheng
 * @date 2021/2/25 14:30
 */
public class CountRangeSum {
    public static void main(String[] args) {
        int i = new CountRangeSum().countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647},-564,3864);
        System.out.println(i);
        StringBuilder s =new StringBuilder();

    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null|| nums.length==0){
            return 0;
        }

        long[] sums = getSum(nums);
        System.out.println(Arrays.toString(sums));
        return process(sums,lower,upper,0,sums.length-1);
    }

    private int process(long[] nums, int lower, int upper, int l, int r) {
        if (l == r) {
            return (nums[l] >= lower && nums[l] <= upper) ? 1 : 0;
        }
        int m = l + ((r - l) >> 1);
        return process(nums, lower, upper, l, m) +
                process(nums, lower, upper, m + 1, r) + merge(nums, lower, upper, l, m, r);

    }

    private int merge(long[] nums, int lower, int upper, int l, int m, int r) {
        int result = 0;
        int wl = l;
        int wr = l;

        for (int i = m + 1; i <= r; i++) {
            long max = nums[i] - lower;
            long min = nums[i] - upper;

            while (wl <= m && nums[wl] < min) {
                wl++;
            }
            while (wr <=m  && nums[wr] <= max) {
                wr++;
            }
            result += (wr - wl);
        }

        long[] help = new long[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;

        while (p1 <= m && p2 <= r) {
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= m) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[l + j] = help[j];
        }
        return result;
    }

    private long[] getSum(int[] nums) {

        long[] sums = new long[nums.length];
        sums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        return sums;
    }


}
