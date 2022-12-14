package com.codewithmosh;

import java.util.Arrays;
import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    // O(1)
    public void enqueue(int item){
        stack1.push(item);
    }
    // O(n)
    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();
        moveStack1ToStack2();
        return stack2.pop();
    }
    // O(n)
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        moveStack1ToStack2();
        return stack2.peek();
    }
    private void moveStack1ToStack2() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
    @Override
    public String toString() {
        Stack temp=stack1.isEmpty()?stack2:stack1;
        int[] items = new int[5];
        int size=temp.size();
        for (int i = 0; i < size; i++) {
            int n = (int) temp.pop();
            items[i] = n;
        }
        return Arrays.toString(items);
    }
}

