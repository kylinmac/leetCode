package com.mc.code;

/**
 * @author macheng
 * @date 2021/2/22 14:54
 */
public class Trap {

    public static void main(String[] args) {
        int[] height=new int[]{4,2,0,3,2,5};
        System.out.println(new Trap().trap(height));
    }
    public int trap(int[] height) {
        boolean flag =false;
        int left=0;
        int leftIndex=0;
        int sum=0;
        for (int i = 0; i < height.length; i++) {
            if (!flag && left<=height[i]){
                leftIndex=i;
                left=height[i];
            }else {
                flag=true;
            }

            if (flag && (i>0 && height[i-1]<height[i])){
                if (i==height.length-1){
                    sum+=calculate(height,leftIndex,i);
                    continue;
                }
                if (height[i]>=height[i+1]){
                    sum+=calculate(height,leftIndex,i);
                    flag=false;
                    leftIndex=i;
                    left=height[i];
                    continue;
                }
            }
        }

        return sum;
    }

    public int calculate(int[] height,int x,int y){
        int high= Math.min(height[x], height[y]);
        int sum=0;
        for (int i = x+1; i < y; i++) {
            sum+=(high-height[i]);
        }
        return sum;
    }
}
