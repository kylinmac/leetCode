package com.mc.code;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author macheng
 * @date 2021/1/11 12:25
 */
public class Utils {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){
        int i=1;
        try {
            return i;
        }finally {
            i++;
            return i;
        }
    }

    int[] getArrayPlus(int i) {
        int[] ints = new int[i];

        for (int j = 0; j < i; j++) {
            ints[j] = RandomUtils.nextInt();
        }

        return ints;
    }

    void swap(int[] ints, int x, int y) {
        int z = ints[x];
        ints[x] = ints[y];
        ints[y] = z;

    }
}
