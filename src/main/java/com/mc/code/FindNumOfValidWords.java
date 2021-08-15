package com.mc.code;

import java.util.*;

/**
 * @author macheng
 * @date 2021/2/26 9:13
 */
public class FindNumOfValidWords {
    public static void main(String[] args) {
        int subset = 0x01001101;
        int mask = 0x01001101;
        do {

            subset = (subset - 1) & mask;
            System.out.println(Integer.toBinaryString(subset));
        } while (subset != mask);


    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        ArrayList<Integer> result= new ArrayList<>();

        int[] ints = processForWords(words);

        int[] puzzleI = processForWords(puzzles);

        for (int i = 0; i < puzzleI.length; i++) {
            int num=0;
            int first=1<<(puzzles[i].charAt(0)-97);

            for (int anInt : ints) {
                if ((first & anInt) != 0 && (anInt | puzzleI[i]) == puzzleI[i]) {
                    num++;
                }
            }

            result.add(num);
        }

        return result;
    }


    private int[] processForWords(String[] words){

        int[] s=new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                s[i]=s[i] | 1<<(words[i].charAt(j)-97);
            }
        }
        return s;
    }

}
