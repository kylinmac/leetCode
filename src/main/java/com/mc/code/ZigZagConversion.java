package com.mc.code;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * @author macheng
 * @date 2020/11/25 13:16
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(test("AB", 1));
    }

    public static String test(String s, int numRows) {
        if (s==null || numRows==1){
            return s;
        }

        StringBuilder result = new StringBuilder();

        ArrayList<StringBuilder> list = new ArrayList<>();


        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int num = s.length();

        int konggeshu = numRows - 2;
        int line = 0;
        boolean addFlag=false;
        boolean lineAdd=true;
        for (int i = 0; i < num; i++) {

            list.get(line).append(s.charAt(i));
            for (int j = 0; j < konggeshu; j++) {
                list.get(line).append(' ');
            }
            if (addFlag){
                konggeshu++;
                if (konggeshu==(numRows-2)){
                    addFlag=(!addFlag);
                }
            }else {
                konggeshu--;
                if (konggeshu==0){
                    addFlag=(!addFlag);
                }
            }

            if (lineAdd){
                line++;
                if (line==(numRows-1)){
                    lineAdd=(!lineAdd);
                }
            }else {
                line--;
                if (line==0){
                    lineAdd=(!lineAdd);
                }
            }


        }
        list.forEach(x -> {
            x.append("\n");
            result.append(x);
        });


        return result.toString();
    }
}
