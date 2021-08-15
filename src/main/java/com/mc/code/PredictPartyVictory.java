package com.mc.code;

import java.util.Arrays;

/**
 * @author macheng
 * @date 2020/12/11 9:30
 */
public class PredictPartyVictory {


    public static void main(String[] args) {
        String s = Arrays.toString("list".split("\\.", 0));
        System.out.println(s);
    }

    public static String predictPartyVictory(String senate) {

      return test(0,0,0,0,senate);

    }

    private static String test(int r,int d,int rp,int dp ,String senate){

        StringBuilder s=new StringBuilder();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i)=='R'){
                if (dp>0){
                    dp--;
                }else {
                    rp++;
                    r++;
                    s.append('R');
                }

            }else {
                if (rp>0){
                    rp--;
                }else {
                    dp++;
                    d++;
                    s.append('D');
                }
            }
        }

        if (r == 0 || d == 0){
            return s.charAt(0)=='D'?"Dire":"Radiant";
        } else {
            return test(0,0,rp,dp,s.toString());
        }
    }



}
