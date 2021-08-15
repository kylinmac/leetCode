package com.mc.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author macheng
 * @date 2021/3/5 16:47
 */
public class Permute {


//    public List<List<Integer>> permute(int[] nums) {
//        Arrays.binarySearch(nums,0,i,nums);
//    }

    private void process(List<List<Integer>> result, ArrayList<Integer> path, int[] nums ,int size){
        if (size==path.size()){
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!result.contains(nums[i])){
              path.add(nums[i]);
              process(result,path,nums,size+1);
              path.remove(size);
            }
        }

    }
}
