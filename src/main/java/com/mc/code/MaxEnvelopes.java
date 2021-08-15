package com.mc.code;

import java.util.*;

/**
 * @author macheng
 * @date 2021/3/4 9:28
 */
public class MaxEnvelopes {

    public static void main(String[] args) {
        System.out.println(-1>>>31);
     // nextGreaterElements(new int[]{1,2,1});
    }



    public static int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i] ) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
            if(nums[i]>max){
                max=nums[i];
            }
        }

        for (int i = 0; i < nums.length && stack.peek()<max;) {
            if (nums[i]>nums[stack.peek()]){
                result[stack.pop()]=nums[i];
                continue;
            }
            i++;
        }

        while (!stack.empty()){
            result[stack.pop()]=-1;
        }

        return result;
    }


    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        int[] result = new int[envelopes.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }

        Arrays.sort(envelopes, (o1, o2) -> (o1[0] < o2[0]) ? -1 : ((o1[0] == o2[0]) ? Integer.compare(o2[1], o1[1]) : 1));

        int x = 1;
        int high = envelopes[0][1];

        for (int i = 1; i < result.length; i++) {
            if (envelopes[i][1] > high) {
                x++;
                high = envelopes[i][1];
            } else {
                int index = Collections.binarySearch(new ArrayList<Integer>(), envelopes[i][1], (o1, o2) -> {
                    return o1 - o2 > 0 ? -1 : 0;
                });

                high = envelopes[i][1];
            }
        }

        return x;
    }

    public int[][] sort(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> (o1[0] < o2[0]) ? -1 : ((o1[0] == o2[0]) ? Integer.compare(o1[1], o2[1]) : 1));
        return envelopes;
    }

    public int process(int[][] envelopes, int next) {
        int result = 1;
        for (int i = next + 1; i < envelopes.length; i++) {
            int sum = 1;
            if (envelopes[i][0] > envelopes[next][0] && envelopes[i][1] > envelopes[next][1]) {
                sum += process(envelopes, i);
            }
            result = Math.max(sum, result);
        }
        return result;
    }


}
