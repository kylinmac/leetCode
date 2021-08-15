package com.mc.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author macheng
 * @date 2021/3/8 9:11
 */
public class MinCut {

    public static void main(String[] args) {
        int aab = new MinCut().minCut("aab");
        System.out.println(aab);
    }

    public int minCut(String s) {
        boolean[][] flag=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(flag[i],true);
        }

        for(int i=flag.length-1;i>=0;i--){
            for(int j=i+1;j<flag.length;j++){
                flag[i][j]=flag[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
            }
        }
        if(flag[0][flag.length-1]){
            return 0;
        }
        Thread t=new Thread();

        int r=Integer.MAX_VALUE;
        int[] dp=new int[flag.length];
        for (int k = 0; k < flag.length; k++) {

            int result=dp[k]+1;
            A:
            for (int i = k; i < flag.length; i++) {
                result++;
                for (int j = flag.length-1; j >=0 ; j--) {
                    if (flag[i][j]){
                        i=j;
                        continue A;
                    }
                }
            }
            if (k==0){
                r=result;
            }

            r=Math.min(result,r);
        }

        return r;
    }



    private void process(List<Integer> result, int offset, List<String> path , String s, boolean[][] flag){
        if (!result.isEmpty() && path.size()>result.get(0)){
            return;
        }
        if(offset==s.length()){
            if (result.isEmpty()){
                result.add(path.size()-1);
                return;
            }
            int min=Math.min(result.get(0),path.size()-1);
            result.set(0,min);
            return ;
        }


        for(int i=offset;i<s.length();i++){
            if(flag[offset][i]){
                path.add(s.substring(offset,i+1));
                process(result,i+1,path,s,flag);
                path.remove(path.size()-1);
            }
        }

    }
}
