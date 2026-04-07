package com.wainrp;

import com.wainrp.array.DynamicArray;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DynamicArray<String> arr = new DynamicArray<>();

        arr.add("Hello");
        arr.add("Hello1");
        arr.add("Hello2");
        arr.add("Hello3");
        arr.removeAt(2);

        System.out.println(arr.get(1));


        ArrayList<String> arr2 = new ArrayList<>();

    }
}