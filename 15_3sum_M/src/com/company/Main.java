package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * @param nums input array of integer
     * @return return all possible a,b,c
     */
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

    private static void test15() {

        // test cases and ground truth
        int[] S0 = {-1, 0, 1, 2, -1, -4};
        //int[] S1 = {0,14,-7,2,7,11,-9,11,-12,6,-10,-8,9,-3,7,-6,3,4,14,-10,-8,5,-1,6,12,9,12,-11,-15,-5,5,0,-6,13,9,9,10,7,5,13,-2,11,-10,-15,-15,4,-14,-4,-15,7,-7,-15,-3,8,-2,-13,-6,-5,-9,-14,5,12,1,6,2,-12,-8,-11,10,13,-13,-14,1,14,8,1,-4,9,4,-12,-6,13,10,6,6,-7,8,7,3,7,8,-15,-4,-14,-1,13,-11,6,-12,-15,4,12,8,-10,4,1,-1,7,-13,-12,10,-4,8,6,10,-1,6,-5,13,-13,9,6,-13,-10};
        int[] S2 = {0,0,0};
        int[] S3 = {-2,-3,0,0,-2};

        List<List<Integer>> s0 = asList(asList(-1,-1,2),asList(-1,0,1));
        List<List<Integer>> s2 = asList(asList(0,0,0));
        List<List<Integer>> s3 = asList();

        // testing
        List<List<Integer>> mys0 = threeSum(S0);
        assert isEqual(s0,mys0): "threeSum: Case 0 fail";
        List<List<Integer>> mys2 = threeSum(S2);
        assert isEqual(s2,mys2): "threeSum: Case 2 fail";
        List<List<Integer>> mys3 = threeSum(S3);
        assert isEqual(s3,mys3): "threeSum: Case 3 fail";
    }

    /**
     * method to initialize list of list<T>
     * @param items data type
     * @param <T> type of list of list
     * @return return an initialized list<list<T>>
     */
    private static <T> List<T> asList(T ... items) {
        List<T> list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }
        return list;
    }

    private static boolean isEqual(List<List<Integer>> A, List<List<Integer>> B) {
        String myA = "";
        String myB = "";
        for(List<Integer> a:A){
            myA = myA.concat(a.toString());
        }

        for(List<Integer> b:B){
            myB = myB.concat(b.toString());
        }
        return myA.equals(myB);
    }

    public static void main(String[] args) {
        test15();
        System.out.println("All pass.");
    }
}

