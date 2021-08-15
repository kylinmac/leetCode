package com.mc.code;

import java.util.Arrays;

/**
 * @author macheng
 * @date 2021/3/17 11:54
 */
public class NumDistinct {

    public static void main(String[] args) {
        new NumDistinct().numDistinct2("babgbag",
                "bag");
    }


    public int numDistinct2(String s, String t) {

        int[][] dp=new int[s.length()][t.length()];

        int x=0;
        for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)==t.charAt(0)){
                    x++;
                }
                dp[i][0]=x;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i)==t.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[s.length()-1][t.length()-1] ;
    }
    private int process(String s,String t,int si,int ti,boolean[][] dp){
        if (ti==t.length()){
            return 1;
        }
        int cur=0;
        for (int i = si; i < s.length(); i++) {
            if (dp[ti][i]){
                cur++;
            }
        }
        return cur;
    }

    public int numDistinct(String s, String t) {



        return process(s,t,0,new StringBuilder());
    }


    private int process(String s,String t,int offset, StringBuilder path){
        int result=0;

        if (t.equals(path.toString())){
            System.out.println(1);
            return 1;
        }
        if ( path.length()==t.length() || offset==s.length()){
            return 0;
        }

        for (int i = offset; i < s.length(); i++) {
            if (s.charAt(i)==t.charAt(path.length())){
                path.append(s.charAt(i));
                result+=process(s,t,i+1,path);
                path.deleteCharAt(path.length()-1);
            }

        }

        return result;
    }

}
