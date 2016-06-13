package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    /**
     * Definition for singly-linked list.
     * */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static int getLen (ListNode head) {
        int count = 1;
        while(head.next != null ) {
            head = head.next;
            count++;
        }
        return count;
    }

    // 15. 3Sums
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);

        for(int p1 = 0; p1 < nums.length-2;p1++) {
            int p2 = p1 + 1;
            int p3 = nums.length - 1;

            if(nums[p1]>0)
                break;
            if(p1>0)
                if(nums[p1] == nums[p1-1])
                    continue;
            if(nums[p2] == 0 && nums[p3] == 0 && nums[p1] == 0){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[p1]);
                temp.add(nums[p2]);
                temp.add(nums[p3]);
                if (!result.contains(temp))
                    result.add(temp);
                break;
            }
            while (p2 < p3) {
                if (nums[p1] + nums[p2] + nums[p3] == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[p1]);
                    temp.add(nums[p2]);
                    temp.add(nums[p3]);
                    if (!result.contains(temp))
                        result.add(temp);
                    if (p3-p2>=2) {
                        p2++;
                        p3--;
                    }
                    else
                        break;
                } else if (nums[p1] + nums[p2] + nums[p3] > 0)
                    p3--;
                else
                    p2++;
            }
        }

        return result;
    }

    // 16. three closest
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int dist = (nums[0]+nums[1]+nums[2]-target);

        if (dist == 0)
            return target;

        for(int p1 = 0; p1 < nums.length-2;p1++){
            int p2 = p1+1;
            int p3 = nums.length-1;
            while(p2 < p3){
                int temp_dist = (nums[p1]+nums[p2]+nums[p3]-target);
                if (temp_dist == 0)
                    return target;
                if(Math.abs(temp_dist)<Math.abs(dist))
                    dist = temp_dist;
                else
                    if(temp_dist>0)
                        p3--;
                    else
                        p2++;
            }
        }
        return dist+target;
    }
    // 82. remove duplicates from sorted list II
    public static ListNode deleteDuplicates(ListNode head) {

    }

    // M229. Majority Element 2
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
    public static void main(String[] args) {
	// write your code here
        // 15. three sum
        // test cases for 15
        int[] S0 = {-1, 0, 1, 2, -1, -4};
        int[] S1 = {0,14,-7,2,7,11,-9,11,-12,6,-10,-8,9,-3,7,-6,3,4,14,-10,-8,5,-1,6,12,9,12,-11,-15,-5,5,0,-6,13,9,9,10,7,5,13,-2,11,-10,-15,-15,4,-14,-4,-15,7,-7,-15,-3,8,-2,-13,-6,-5,-9,-14,5,12,1,6,2,-12,-8,-11,10,13,-13,-14,1,14,8,1,-4,9,4,-12,-6,13,10,6,6,-7,8,7,3,7,8,-15,-4,-14,-1,13,-11,6,-12,-15,4,12,8,-10,4,1,-1,7,-13,-12,10,-4,8,6,10,-1,6,-5,13,-13,9,6,-13,-10};
        int[] S2 = {0,0,0};
        int[] S3 = {-2,-3,0,0,-2};
        // test cases for 16
        int[] S4 = {1,1,-2};
        int[] S5 = {-1,2,1,-4};
        int[] S6 = {0,1,2};

        long t1 = System.currentTimeMillis();
        List<List<Integer>> result15 = threeSum(S3);
        long t2 = System.currentTimeMillis();
        System.out.println("000");
        for(int i = 0; i < result15.size();i++)
            System.out.println(result15.get(i));
        System.out.println(t2-t1);
        System.out.println("000");

        // 16. three sum closest
        System.out.println("QQQ");
        System.out.println(threeSumClosest(S6,3));
        System.out.println("QQQ");

        // 229. Majority Elements ||
        int[] nums2_1  = {1,2,3};
        int[] nums2_2 = {1,2};
        int[] nums2_3 = {1};
        int[] nums2_4 = {};
        int[] nums2_5 = {1,2,2};
        int[] nums2_6 = {1,2,2,2,2,5,5,5};
        List<Integer> result = majorityElement2(nums2_1);
        majorityElement2(nums2_2);
        majorityElement2(nums2_3);
        majorityElement2(nums2_4);
        majorityElement2(nums2_5);
        majorityElement2(nums2_6);
    }
}
