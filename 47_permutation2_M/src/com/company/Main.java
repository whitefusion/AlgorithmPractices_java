package com.company;

import java.util.*;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.

public class Main {
    static List<List<Integer>> result;
    static boolean[] used;
    static Set<List<Integer>> set;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        set = new HashSet<>();
        helper(nums,temp);
        if(nums.length == 0)
            return result;
        for(List<Integer> ele: set)
            result.add(ele);

        return result;
    }

    private static void helper(int[] nums,List<Integer> temp) {
        if(temp.size() == nums.length) {
            List<Integer> list = new ArrayList<>(temp);
            set.add(list);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;
                else {
                    used[i] = true;
                    temp.add(nums[i]);
                    helper(nums, temp);
                    temp.remove(temp.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void test47(){
        int[] num1 = {1,1,2};
        int[] num2 = {1,2};
        int[] num3 = {1};
        List<List<Integer>> n1 = permuteUnique(num1);
        List<List<Integer>> n2 = permuteUnique(num2);
        List<List<Integer>> n3 = permuteUnique(num3);
        for(List<Integer> n: n3){
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
	// write your code here
        test47();
    }
}
