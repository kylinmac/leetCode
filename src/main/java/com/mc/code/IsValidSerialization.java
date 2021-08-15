package com.mc.code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author macheng
 * @date 2021/3/12 9:51
 */
public class IsValidSerialization {

    public static void main(String[] args) {
        boolean validSerialization = isValidSerialization(
                "9,3,4,#,#,1,#,#,2,#,6,#,#");
        System.out.println(validSerialization);
    }

    public static boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");

        int nums = split.length;

        if (nums % 2 == 0) {
            return false;
        }

        Stack<String> s = new Stack<>();
        s.push(split[0]);

        for (int i = 1; i < split.length; i++) {
            if (split[i - 1].equals("#")) {
                if (s.empty()) {
                    return false;
                }
                s.pop();
            }
            if (!split[i].equals("#")) {
                s.push(split[i]);
            }

        }

        return s.isEmpty();
    }


}
