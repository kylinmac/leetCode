package com.mc.code;

import java.util.Stack;

/**
 * @author macheng
 * @date 2021/2/25 11:23
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.empty()) {
                    result=Math.max(result,i-stack.peek());
                }else {
                    stack.push(i);
                }
            }
        }

        return result;
    }
}
