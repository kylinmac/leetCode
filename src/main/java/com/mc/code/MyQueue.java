package com.mc.code;

import java.util.Stack;

/**
 * @author macheng
 * @date 2021/3/5 9:05
 */
public class MyQueue {


    int size=0;
    Stack<Integer> stackI=new Stack();
    Stack<Integer> stackO=new Stack();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackI.push(x);
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackO.empty()){
            for (int i = 0; i < size; i++) {
                stackO.push(stackI.pop());
            }
        }
        size--;
       return stackO.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackO.empty()){
            for (int i = 0; i < size; i++) {
                stackO.push(stackI.pop());
            }
        }
        return stackO.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size==0;
    }
}
