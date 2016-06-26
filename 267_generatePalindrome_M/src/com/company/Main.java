package com.company;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Main {

    static int[] counter;
    static List<String> result;
    static List<String> element;
    static Set<String> set ;
    static boolean[] used;
    static String mid;

    public static List<String> generatePalindromes(String s) {
        counter = new int[128];
        mid = "";
        result = new ArrayList<>();
        element = new ArrayList<>();
        set = new HashSet<>();

        if(existPalindrome(s)) {

            buildElement(s);
            String temp = "";
            helper(s,temp);
            for(String n: set) {
                result.add(n);
            }
        }
        return result;
    }

    private static void buildElement(String s) {
        for(int i = 0;i < 128;i++) {
            if(counter[i]%2==1){
                mid = Character.toString((char)i);
                for(int j = 0; j <(counter[i]/2);j++)
                    element.add(Character.toString((char)i));
            } else if(counter[i]!=0 && counter[i]%2 == 0){
                for(int j = 0; j <(counter[i]/2);j++)
                    element.add(Character.toString((char)i));
            }
        }

        used = new boolean[element.size()];
    }

    private static void helper(String s, String temp) {
        if(temp.length() == element.size()){
            String ele = new String(temp);
            String ele_reverse = new StringBuilder(ele).reverse().toString();
            ele = ele + mid + ele_reverse;
            set.add(ele);
        } else {
            for(int i = 0; i < element.size();i++) {

                if(used[i] == true)
                    continue;
                else{
                    used[i] = true;
                    temp += element.get(i);
                    helper(s,temp);

                    temp = temp.substring(0,temp.length()-1);

                    used[i] = false;
                }
            }
        }
    }

    private static boolean existPalindrome(String s) {

        int odd = 0;
        for(int i = 0; i< s.length();i++){
            counter[s.charAt(i)]++;
            if((counter[s.charAt(i)] & 1) == 1)
                odd++;
            else
                odd--;
        }
        return odd <= 1;
    }

    private static void test267(){
        String s1 = "abc";
        String s2 = "aabbbb";
        String s3 = "a";
        String s4 = "aaa";
        String s5 = "aacbbbb";
        String s6 = "ababcdcdffggk";
        System.out.println(generatePalindromes(s4));
        System.out.println(generatePalindromes(s5));
        System.out.println(generatePalindromes(s2));
    }

    public static void main(String[] args) {
        test267();
    }
}
