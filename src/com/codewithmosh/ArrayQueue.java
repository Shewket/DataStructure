package com.codewithmosh;


import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayQueue {
    private int[] items;
    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int capacity){
        items = new int[capacity];
    }

    public void enqueue(int item){
        if (count == items.length)
            throw new IllegalStateException();
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue(){
        Integer item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    public int peek(){
        if (isEmpty())
            throw new EmptyStackException();
        return items[front];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
