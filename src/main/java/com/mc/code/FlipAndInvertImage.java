package com.mc.code;

/**
 * @author macheng
 * @date 2021/2/24 9:01
 */
public class FlipAndInvertImage {

    public static void main(String[] args) {

    }

    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (A[i].length+1)/2; j++) {

                swap(A[i],j,A[i].length-1-j);
            }
        }

        return A;
    }


    private void swap(int[] ints, int x, int y) {
        int z=ints[y]^1;
        ints[y]=ints[x]^1;
        ints[x]=z;
    }
}
