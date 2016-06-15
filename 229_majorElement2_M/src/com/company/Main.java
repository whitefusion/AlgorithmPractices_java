package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array of size n,
//find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

public class Main {
    public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> myList = new ArrayList<Integer>();
        Arrays.sort(nums);

        int count = 0; int candidate = 0;
        if (nums.length == 0)
            return myList;
        if(nums.length == 1)
            myList.add(nums[0]);
        if(nums.length >= 2) {
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                    count++;
                } else {
                    if (candidate == nums[i])
                        count++;
                    else {
                        if (count > nums.length / 3) {
                            myList.add(candidate);
                        }
                        count = 1;
                        candidate = nums[i];
                    }
                }
            }
            if (count > nums.length / 3) {
                myList.add(candidate);
            }
        }
        System.out.println(myList);
        return myList;
    }

    private static void test229() {
        int[] nums1 = {1,2,3};
        int[] nums2 = {1,2};
        int[] nums3 = {1};
        int[] nums4 = {};
        int[] nums5 = {1,2,2};
        int[] nums6 = {1,2,2,2,2,5,5,5};

        List<Integer> n1 = new ArrayList<Integer>();
        List<Integer> n2 = new ArrayList<Integer>();
        n2.add(1);n2.add(2);
        List<Integer> n3 = new ArrayList<Integer>();
        n3.add(1);
        List<Integer> n4 = new ArrayList<Integer>();
        List<Integer> n5 = new ArrayList<Integer>();
        n5.add(2);
        List<Integer> n6 = new ArrayList<Integer>();
        n6.add(2);n6.add(5);

        // Testing
        assert Test(n1,nums1) : "Case 1 fails";
        assert Test(n2,nums2) : "Case 2 fails";
        assert Test(n3,nums3) : "Case 3 fails";
        assert Test(n4,nums4) : "Case 4 fails";
        assert Test(n5,nums5) : "Case 5 fails";
        assert Test(n6,nums6) : "Case 6 fails";

    }

    private static boolean Test(List<Integer> n_true,int[] n) {
        return n_true.equals(majorityElement2(n));
    }
    public static void main(String[] args) {
        test229();
        System.out.println("All pass.");
    }
}
