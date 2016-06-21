package com.company;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;

public class Main {
    public static String getPermutation(int n, int k) {

        String result = "";
        ArrayList<String> nString = new ArrayList<>(n);

        for(int i = 0; i < n; i++)
            nString.add(Integer.toString(i+1));

        k--;
        for(int i = n; i >=1; i--) {
            long j = k/factorial(i-1);
            k %= factorial(i-1);
            result = result.concat(nString.get((int)j));
            nString.remove((int)j);
        }
        return result;
    }

    private static long factorial(int num) {
        if (num <= 0)
            return 1;
        else
            return num * factorial(num-1);
    }

    private static void test60() {
        String r1 = getPermutation(4,9);
        assert r1.equals("2314") : "Case 0 failed";
        String r2 = getPermutation(3,1);
        assert r2.equals( "123")  : "Case 1 failed";
        String r3 = getPermutation(2,2);
        assert r3.equals( "21")   : "Case 2 failed";

    }

    public static void main(String[] args) {
	// write your code here
        test60();
        System.out.println("All pass");
    }
}
