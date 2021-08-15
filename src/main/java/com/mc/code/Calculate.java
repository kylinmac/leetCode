package com.mc.code;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author macheng
 * @date 2021/3/10 8:50
 */
public class Calculate {
    public static void main(String[] args) {
        System.out.println(cal("3/2"));
    }

    public static  int cal(String s){

        Stack<Character> fuhao=new Stack<>();
        Stack<Integer> num=new Stack<>();
        boolean cal=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
           if (s.charAt(i) == '+' || s.charAt(i)=='-'){
                   fuhao.push(s.charAt(i));
            }else if (s.charAt(i) == '*' || s.charAt(i) == '/'){
              fuhao.push(s.charAt(i));
               cal=true;
           }else{
                int n=s.charAt(i)-'0';
                for(int j=i+1 ;j<s.length() && s.charAt(j) >='0' && s.charAt(j)<='9';j++,i++){
                    n=n*10+s.charAt(j)-'0';
                }
               num.push(n);
                if (cal){
                    Integer p1 = num.pop();
                    Integer p2 = num.pop();
                    Character fu = fuhao.pop();
                    if (fu=='*'){
                        num.push(p1*p2);
                    }else {
                        num.push(p1/p2);
                    }
                    cal=false;
                }
            }
        }
        int result=0;
        while (!fuhao.empty()){
            Character pop = fuhao.pop();
            if (pop=='+'){
                result+=num.pop();
            }else {
                result-=num.pop();
            }
        }
        while (!num.empty()){
            result+=num.pop();
        }
        return result;

    }


    public static int calculate2(String s) {

        Stack<Integer> stack=new Stack();
        stack.add(1);
        stack.add(1);
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
            if(s.charAt(i) == '('){
                stack.push(stack.peek());
            }else if (s.charAt(i) == ')'){
                stack.pop();
            }else if (s.charAt(i) == '+'){
                stack.push(stack.peek());
            }else if (s.charAt(i) == '-'){

                    stack.push(stack.peek()*-1);
            }else{
                int n=s.charAt(i)-'0';
                for(int j=i+1 ;j<s.length() && s.charAt(j) >='0' && s.charAt(j)<='9';j++,i++){
                    n=n*10+s.charAt(j)-'0';
                }
                result=result+stack.pop()*n;
            }
        }

        return result;
    }
    public static int calculate(String s) {

        int result = 0;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
            } else if (s.charAt(i) == '(') {
                stack.push(s.charAt(i) + "");
            } else if (s.charAt(i) == ')') {
                int cal = 0;
                while (!stack.peek().equals("(")) {
                    String num1 = stack.pop();
                    String fuhao = stack.pop();
                    if (fuhao.equals("+")) {
                        cal = cal + Integer.valueOf(num1);
                        continue;
                    }
                    if (fuhao.equals("-")) {
                        cal = cal - Integer.valueOf(num1);
                        continue;
                    }
                    if (fuhao.equals("(")) {
                        cal = cal + Integer.valueOf(num1);
                        stack.push("(");
                        continue;
                    }
                }
                stack.pop();
                stack.push(""+cal);

            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                stack.push("" + s.charAt(i));
            } else {
                if (!stack.empty() && s.charAt(i - 1) > 47 && s.charAt(i - 1) < 58) {
                    stack.push(stack.pop() + s.charAt(i));
                } else {
                    stack.push(s.charAt(i) + "");

                }
            }




        }
        while (!stack.empty()){
            String pop = stack.pop();
            if (stack.empty()){
                result=result+Integer.valueOf(pop);
                break;
            }
            String fuhao=stack.pop();
            if (fuhao.equals("+")) {
                result = result + Integer.valueOf(pop);
                continue;
            }
            if (fuhao.equals("-")) {
                result = result - Integer.valueOf(pop);
                continue;
            }
        }
        return result;
    }
}
