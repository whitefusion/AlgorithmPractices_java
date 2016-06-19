package com.company;

public class Main {
    // the state of a robber facing a house i is denoted as curr[i]
    // the state transition function is max(curr[i], curr[i-1]+nums[i])
    //dynamic programming
    public static int rob(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        int curr = nums[0];
        int prev = 0;
        int next = 0;
        for(int i = 1; i < nums.length;++i){
            next = Math.max(curr,prev+nums[i]);
            prev = curr;
            curr = next;
        }
        System.out.println(Math.max(curr,next));
        return Math.max(curr,next);
    }

    private static void test198() {
        int[] nums1 = {};
        int[] nums2 = {100};
        int[] nums3 = {99,100};
        int[] nums4 = {1,99,99};
        int[] nums5 = {100,50,99,100};

        assert rob(nums1) == 0 : "Case 1 fails";
        assert rob(nums2) == 100 : "Case 2 fails";
        assert rob(nums3) == 100 : "Case 3 fails";
        assert rob(nums4) == 100 : "Case 4 fails";
        assert rob(nums5) == 200 : "Case 5 fails";
    }

    public static void main(String[] args) {
        test198();
        System.out.println("All pass.");
    }
}
