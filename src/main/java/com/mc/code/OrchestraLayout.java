package com.mc.code;

/**
 * @author macheng
 * @date 2021/4/6 13:44
 */
public class OrchestraLayout {

    public static void main(String[] args) {
        System.out.println(orchestraLayout(449572,209397,306801));
    }



    public static int orchestraLayout(int num, int xPos, int yPos) {
        int quan = Math.min(xPos + 1<num/2?xPos+1:num-xPos, yPos + 1<num/2?yPos+1:num-yPos);
        System.out.println(quan);
        System.out.println(num-1);
        System.out.println(num-2*(quan-1)+1);
        long result = (((num-1+num-2*(quan-1)+1))%9)*2*(quan-1);
        if (xPos+1==quan){
            result+=yPos-quan+1;
        }else if(yPos+1==quan){
            result+=((num-2*quan+1)%9)*3+(num-quan-xPos);
        }else if(num-xPos==quan){
            result+=((num-2*quan+1)%9)*2+(num-quan-yPos);
        }else {
            result+=((num-2*quan+1)%9)+(xPos-quan);
        }

        return result % 9 == 0 ? 9 : (int)result % 9;
    }
}
