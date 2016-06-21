package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static List<List<Integer>> result;
    static boolean[] used;

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        result = new LinkedList<>();
        used = new boolean[nums.length];
        helper(nums,temp);
        return result;
    }

    private static void helper(int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            List<Integer> list = new LinkedList<>(temp);
            result.add(list);
        } else {
            for(int i = 0; i < nums.length; i++) {
                // skip the ele that has met before
                if(used[i])
                    continue;
                used[i] = true;
                temp.add(nums[i]);
                helper(nums,temp);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
        }
    }


    private static void test46(){
        int[] num1 = {1,2,3,4};

        List<List<Integer>> n1 = permute(num1);
        for(List<Integer> n: n1){
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
	// write your code here
        test46();
    }
}
