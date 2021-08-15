package com.mc.code;

/**
 * @author macheng
 * @date 2021/2/22 14:14
 */
public class IsToeplitzMatrix {


    public boolean isToeplitzMatrix(int[][] matrix) {

        int x=matrix.length-2;
        int y=0;
        boolean flag=true;
        while (x!=0){

            if (!check(matrix,x--,y)){
                flag=false;
                break;
            }

        }
        while (flag && y!=matrix[0].length-1){

            if (!check(matrix,x,y++)){
                flag=false;
                break;
            }

        }
        return flag;
    }

    private boolean check(int[][] matrix,int x,int y){
        int result=matrix[x][y];
        boolean flag=true;
        while (x!=matrix.length-1&&y!=matrix[0].length-1){
            if (result!=matrix[++x][++y]){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
