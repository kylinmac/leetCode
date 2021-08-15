package com.mc.code;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author macheng
 * @date 2020/12/25 16:58
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sss=0;
        int num=0;
        for (int k : g) {
            for (int j = sss; j < s.length; j++) {
                sss++;
                if (k <= s[j]) {
                    num++;
                    break;
                }
            }
            if (sss == s.length) {
                return num;
            }
        }
        return g.length;
    }
}
