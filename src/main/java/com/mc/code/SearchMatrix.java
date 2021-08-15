package com.mc.code;

/**
 * @author macheng
 * @date 2021/3/30 9:34
 */
public class SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {

       int h= hbsearch(matrix,target,0,matrix.length-1);
       if (matrix[h][0]==target){
           return true;
       }
        return binarySearch(matrix[h],target,0,matrix[h].length);
    }

    public int hbsearch(int[][] matrix,int target ,int x,int y){
        if (x==y){
            return x;
        }
        if(matrix[(x+y)>>1][0] == target){
            return (x+y)>>1;
        }
        if (matrix[(x+y)>>1][0] > target){
            if (matrix[((x+y)>>1)-1][0]<target){
                return ((x+y)>>1)-1;
            }else {
                return hbsearch(matrix,target,x,(x+y)>>1);
            }
        }else {
            if (matrix[((x+y)>>1)+1][0]>target){
                return ((x+y)>>1)+1;
            }else {
                return hbsearch(matrix,target,(x+y)>>1,y);
            }
        }
    }


    public boolean binarySearch(int[] array,int target ,int x,int y){
       if (x==y ) {
          return target == array[x];
       }
       if (array[(x+y)>>1]==target){
           return true;
       }else {
           if (array[(x+y)>>1]>target){
               return binarySearch(array,target,x,(x+y)>>1);
           }else {
               return binarySearch(array,target,(x+y)>>1,y);
           }
       }

    }
}
