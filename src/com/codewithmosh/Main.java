package com.codewithmosh;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int [] numbers = {};
        var sorter = new QuickSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
