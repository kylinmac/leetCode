package com.mc.code;

/**
 * @author macheng
 * @date 2020/12/10 14:33
 */
public class LemonadeChange {


    public boolean lemonadeChange(int[] bills) {


        int fNum = 0;
        int tNum = 0;
        boolean flag = true;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fNum++;
                continue;
            }
            if (bills[i] == 10) {
                if (fNum < 1) {
                    flag = false;
                    break;
                }
                tNum++;
                fNum--;
                continue;
            }
            if (bills[i] == 20) {
                if (fNum < 1) {
                    flag = false;
                    break;
                }
                if (tNum < 1) {
                    if (fNum < 3) {
                        flag = false;
                        break;
                    }
                    fNum -= 3;
                } else {
                    tNum--;
                    fNum--;
                }

            }
        }
        return flag;
    }


}
