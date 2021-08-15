package com.mc.code;

import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author macheng
 * @date 2021/3/7 10:44
 */
public class Palindrome {
    public static void main(String[] args) {
        List<List<String>> aab = partition("aab");
        System.out.println(aab);
    }

    public static List<List<String>> partition(String s) {
        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int i = 0; i < flag.length; i++) {
            Arrays.fill(flag[i], true);
        }

        for (int i = flag.length; i>=0; i--) {
            for (int j = i + 1; j < flag.length; j++) {
                flag[i][j] = (s.charAt(i) == s.charAt(j)) & flag[i + 1][j - 1];
            }
        }
        for (int i = 0; i < flag.length; i++) {
            System.out.println(Arrays.toString(flag[i]));
        }
        flag = new boolean[s.length()][s.length()];
        for (int i = 0; i < flag.length; i++) {
            Arrays.fill(flag[i], true);
        }
        for (int i = flag.length - 1; i >= 0; --i) {
            for (int j = i + 1; j < flag.length; ++j) {
                flag[i][j] = (s.charAt(i) == s.charAt(j)) && flag[i + 1][j - 1];
            }
        }

        System.out.println("=========================");

        for (int i = 0; i < flag.length; i++) {
            System.out.println(Arrays.toString(flag[i]));
        }
        List<List<String>> result =new ArrayList<>();
        ArrayList<String> path=new ArrayList<>();
        process(s,0,flag,result,path);
        return result;
    }


    private static int find(String s, int start, int mid) {
        for (; start < s.length() && (((mid << 1) - start) >= 0); start++) {
            if (s.charAt(start) != s.charAt((mid << 1) - start)) {
                return start - 1;
            }
        }
        return start - 1;
    }

    private static void process(String s, int offset, boolean[][] flag, List<List<String>> result, List<String> path) {
        if (s.length()==offset){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = offset; i < s.length(); i++) {
            if (flag[offset][i]){
                path.add(s.substring(offset,i+1));
                process(s,i+1,flag,result,path);
                path.remove(path.size()-1);
            }
        }

    }

}
