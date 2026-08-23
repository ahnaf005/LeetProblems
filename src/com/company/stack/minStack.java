package com.company.stack;

import java.util.ArrayDeque;
import java.util.Stack;

class MinStack {
    ArrayDeque<int[]> stack;
    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        }else{
            stack.push(new int[]{val, Math.min(stack.peek()[1],val)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
