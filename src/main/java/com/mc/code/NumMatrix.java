package com.mc.code;

/**
 * @author macheng
 * @date 2021/3/2 9:07
 */
public class NumMatrix {


    public static void main(String[] args) {
    }

    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return;
        }
        sumMatrix=new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sumMatrix[i+1][j+1]=sumMatrix[i][j+1]+sumMatrix[i+1][j]-sumMatrix[i][j]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2+1][col2+1]+sumMatrix[row1][col1]-sumMatrix[row1][col2]-sumMatrix[row2][col1];
    }

}
