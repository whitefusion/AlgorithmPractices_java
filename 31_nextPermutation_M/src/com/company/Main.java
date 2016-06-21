package com.company;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return;
        // find the first number that violates ascending rule
        // from right to left
        int p1 = -1;
        for(int i = nums.length-1; i > 0; i--){
            int j = i -1;
            if(nums[j] < nums[i]) {
                p1 = j;
                break;
            }
        }

        if (p1 == -1) {
            Arrays.sort(nums);
            return;
        }
        // find the first number that is bigger than the number found
        // from right to left
        int p2 = p1;
        for(int i = nums.length-1;i>0;i--) {

            if(nums[i]>nums[p1]) {
                p2 = i;
                break;
            }
        }

        // swap nums[p1] and nums[p2]
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;

        // sort the array after p1
        int k = p1+1;
        int q = nums.length-1;
        while (k < q) {
            temp = nums[k];
            nums[k] = nums[q];
            nums[q] = temp;
            k++;
            q--;
        }
    }

    private static void test31() {
        int[] num1 = {1,1,5};
        int[] num2 = {1};
        int[] num3 = {};
        int[] num4 = {1,2,3};
        int[] num5 = {3,2,1};
        int[] num6 = {6,8,7,4,3,2};
        int[] num7 = {1,2};

        int[] n1 = {1,5,1};
        int[] n2 = {1};
        int[] n3 = {};
        int[] n4 = {1,3,2};
        int[] n5 = {1,2,3};
        int[] n6 = {7,2,3,4,6,8};
        int[] n7 = {2,1};

        nextPermutation(num1);
        nextPermutation(num2);
        nextPermutation(num3);
        nextPermutation(num4);
        nextPermutation(num5);
        nextPermutation(num6);
        nextPermutation(num7);

        assert  Arrays.equals(num1,n1):"Case 1 failed";
        assert  Arrays.equals(num2,n2):"Case 2 failed";
        assert  Arrays.equals(num3,n3):"Case 3 failed";
        assert  Arrays.equals(num4,n4):"Case 4 failed";
        assert  Arrays.equals(num5,n5):"Case 5 failed";
        assert  Arrays.equals(num6,n6):"Case 6 failed";
        assert  Arrays.equals(num7,n7):"Case 7 failed";

      }
    public static void main(String[] args) {
	// write your code here
        test31();
    }
}
