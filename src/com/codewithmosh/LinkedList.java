package com.codewithmosh;


import javax.lang.model.element.VariableElement;
import java.awt.*;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(){}

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    //  addFirst
    public void addFirst(int item){
        Node node = new Node(item);
        if (isEmpty())
            first =last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    private boolean isEmpty(){
        return first == null;
    }


    //  addLast
    public void addLast(int item){
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

 /*   //  deleteFirst
    public void removeFirst(){
        //  [10 -> 20 -> 30]
        //  first -> 20
        //  [20 -> 30]
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last){
            first = last = null;
            return;
        }
        if (first != null){
            first.value = first.next.value;
            first.next = first.next.next;
        }
    }*/
    public void removeFirst(){
        //  [10 -> 20 -> 30]
        //  first -> 20
        //  [20 -> 30]
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else{
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    //  deleteLast
  /*  public void removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last){
            first = last = null;
            return;
        }
        Node current = first;
        while (current.next.next != null)    current = current.next;
        last = current;
        current.next = null;

    }*/
   public void removeLast(){
       //   [10 -> 20 -> 30]
       //   previous -> 20
       //   last -> 20
       //   [10 -> 20]
       if (isEmpty())
           throw new NoSuchElementException();
       if (first == last)
           first = last = null;
       else{
           Node previous = getPrevious(last);
           last = previous;
           last.next = null;
       }
       size--;
   }

   private Node getPrevious(Node node){
       Node current = first;
       while (current != null){
           if (current.next == node)   return current;
           current = current.next;
       }
       return null;
   }


    //  contains
    /*public boolean contain(int item){
        Node current = first;
        while (current != null){
            if (current.value == item)  return true;
            current = current.next;
        }
        return false;
    }*/
    public boolean contain(int item){
        return indexOf(item) != -1;
    }

    //  indexOf
    public int indexOf(int item){
        int index = 0;
        Node current = first;
        while (current != null){
            if (current.value == item)  return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    //  print
    /*public void print(){
        Node node = new Node();
        while (node != null){
            System.out.print(node.value+" ");
            node= node.next;
        }
    }*/
    public void print(){
        Node current =first;
        while (current != null){
            System.out.print(current.value+" ");
            current= current.next;
        }
    }

    /*public int size(){
        int index = 0;
        Node current = first;
        while (current != null){
            current = current.next;
            index++;
        }
        return index;
    }*/

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        //   first       last
        //  [10 -> 20 -> 30]
        //   p     c     n     (previous current next)
        //  n = c.next
        //  c.next = p
        if (isEmpty())  return;
        Node previous = first;
        Node current  = first.next;
        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    //  Find the Kth node form the end of a linked list in one pass.
    //  [10 -> 20 -> 30 -> 40 -> 50]
    //   *(first)    *(second)
    //               *(first)    *(second)
    //  k = 1 (50)
    //  k = 2 (40)
    //  k = 3 (30)  (distance = 2)
    public int getKthFromTheEnd(int k){
        if (isEmpty())
            throw new IllegalStateException();
        Node a = first;
        Node b = first;
        for (int i = 0; i < k-1; i++){
            b = b.next ;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }
}
