package com.mc.code;

import java.util.Arrays;

/**
 * @author macheng
 * @date 2021/2/25 9:31
 */
public class Transpose {
    public static void main(String[] args) {

        int[][] matrix =new int[2][3];
        matrix[0]=new int[]{1,2,3};
        matrix[1]=new int[]{4,5,6};
        System.out.println(Arrays.deepToString(new Transpose().transpose(matrix)));
    }
    public int[][] transpose(int[][] matrix) {
        int h=matrix.length;
        int l=matrix[0].length;

        int[][] result=new int[l][h];

        for(int i=0;i<h;i++){
            for(int j=0;j<l;j++){
                result[j][i]=matrix[i][j];
            }
        }
        return result;

    }


}
