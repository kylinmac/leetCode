package com.mc.code;

/**
 * @author macheng
 * @date 2020/12/10 15:43
 */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("21474836460"));
    }
    public static int myAtoi(String s) {

        if (s == null || s == "") {
            return 0;
        }
        long result = 0;
        StringBuilder ans = new StringBuilder();
        int validIndex = 0;
        for (; validIndex < s.length(); validIndex++) {
            if (s.charAt(validIndex) != ' ') {
                break;
            }
        }
        if (validIndex >= s.length()) {
            return 0;
        }
        int mul = 1;
        if (s.charAt(validIndex) == '+' || s.charAt(validIndex) == '-') {
            if (s.charAt(validIndex) == '-') {
                mul = -1;
            }
            validIndex++;
        }
        if (validIndex >= s.length()) {
            return 0;
        }
        for (int i = validIndex; i < s.length(); i++) {
            if(s.charAt(i) == 48){
                validIndex++;
            }else {

                break;
            }
        }
        if (validIndex >= s.length()) {
            return 0;
        }
        for (int i = validIndex; i < s.length(); i++) {
            if((s.charAt(i) > 57) || (s.charAt(i) < 48)){
                break;
            }else {
                ans.append(s.charAt(i));
            }
        }

        if(ans.length()==0){
            return 0;
        }

        result=(ans.charAt(0)-48)*mul;

        for (int i = 1; i <ans.length(); i++) {

            result=result*10+mul*(ans.charAt(i)-48);

            if (result>Integer.MAX_VALUE ){
                return Integer.MAX_VALUE;
            }
            if (result<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }

        }

        return (int)result;


    }

}
