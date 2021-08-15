package com.mc.code;

/**
 * @author macheng
 * @date 2021/3/9 9:06
 */
public class RemovingDup {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaaaaay"));
    }
    public static String removeDuplicates(String S) {
        if(S==null || S.length()<=1){
            return S;
        }

        StringBuilder ans=new StringBuilder("");

        for (int i = 1; i < S.length(); i++) {
            if (ans.length()==0&&i<S.length()-1){
                ans.append(S.charAt(i));
                continue;
            }
            if (S.charAt(i)==ans.charAt(ans.length()-1)){
                ans.deleteCharAt(ans.length()-1);
            }else {
                ans.append(S.charAt(i));
            }
        }


        return ans.toString();
    }
}
