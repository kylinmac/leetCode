package com.mc.code;

/**
 * @author macheng
 * @date 2021/3/9 17:44
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
    public static boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        for (int i = 0; i <( s.length()>>1) +1; i++) {

            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
