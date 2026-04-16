package com.wainrp;

import com.wainrp.array.DynamicArray;
import com.wainrp.linkedlist.DefaultDoublyLinkedList;
import com.wainrp.linkedlist.DefaultSinglyLinkedList;

import java.util.*;

public class Main {

    public static int Fibonacci(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        else return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            for(int i =0; i<str.length(); i++){
                count[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            System.out.println(key);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }
        return new ArrayList<>(res.values());
    }
    public static void main(String[] args) {
//        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        int i = 1;
        int j = ++i;
        System.out.println(j);


    }
}