package com.codewithmosh;

import java.util.Arrays;
import java.util.LinkedList;

public class StackList {
    private LinkedList items = new LinkedList();
    private int count;

    public void push(int item){
        items.addLast(item);
        count++;
    }

    public int pop(){
        count--;
        return (int) items.removeLast();
    }

    public int peek(){
        return (int) items.getLast();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    @Override
    public String toString(){
        Object[] object = items.toArray();
        return Arrays.toString(object);
    }
}
