/**
 * Created by Shin on 6/14/2016.
 */

import java.util.Arrays;


/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class Main {
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

    private static void test16() {

        int[] S1 = {1,1,-2};
        int[] S2 = {-1,2,1,-4};
        int[] S3 = {0,1,2};
        int[] S4 = {0,0,0};

        assert threeSumClosest(S1,1) == 0: "Case 1 fails";
        assert threeSumClosest(S2,1) == 2: "Case 2 fails";
        assert threeSumClosest(S3,1) == 3: "Case 3 fails";
        assert threeSumClosest(S4,1) == 0: "Case 4 fails";

    }
    public static void main(String args[]) {
        test16();
        System.out.println("all pass");
    }
}
