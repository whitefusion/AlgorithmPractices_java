package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<Integer>> result;
    public static List<List<Integer>> combine(int n, int k) {

        result = new ArrayList<>();
        if(n < 0 || n < k)
            return result;
        List<Integer> Item = new ArrayList<>();
        backtrack(n,k,1,Item);
        return result;
    }

    private static void backtrack(int n, int k, int start, List<Integer> Item) {
        if(Item.size() == k) {
            result.add(new ArrayList<Integer>(Item));

        }
        else{
            for(int i = start; i <= n;i++){
                Item.add(i);
                backtrack(n,k,i+1,Item);
                Item.remove(Item.size()-1);

            }
        }

    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(combine(4,2));
    }
}
