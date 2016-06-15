package com.company;
import java.util.*;

public class Main {
    /**
     * Definition for singly-linked list.
     * */
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static int getLen (ListNode head) {
        int count = 1;
        while(head.next != null ) {
            head = head.next;
            count++;
        }
        return count;
    }

    // 1. two sum
    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;
        boolean found = false;
        for(int i = 0; i < nums.length-1;i++){
            for(int j = i+1; j < nums.length;j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        return result;
    }

    // E19. Remove Nth Node From End of List
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;


        for(int i = 0; i < n ; i++)
            fast = fast.next;

        if (fast == null)
            return head.next;

        while(fast.next != null) {
            fast= fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
    // 26. Remove Duplicates from Sorted Array
    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0;
        int j = 1;
        int prev = nums[0];
        for(;i < nums.length;i++) {

            if(prev == nums[i])
                continue;
            prev = nums[i];
            j++;
            nums[j-1] = nums[i];
        }
        return j;
    }

    // 27. Remove Element
    private static int removeElement(int[] nums, int val) {

        int j = 0;
        int k = 0;
        for(; k < nums.length;k++){

            if(nums[k] == val) {
                continue;
            }
            nums[j]  = nums[k];
            j++;
        }
        return j;
    }

    // 83. Remove Duplicates from Sorted List
    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode myhead = new ListNode(head.val);
        ListNode currA = head;
        ListNode currB = myhead;

        if (head.next == null)
            return myhead;

        while(currA.next!=null) {
            if(currA.val != currA.next.val) {
                currB.next = currA.next;
                currB = currB.next;
            }
             currA = currA.next;
        }
        currB.next = null;
        return myhead;
    }

    // E160. Intersection of Two Linked Lists
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        } else {
            ListNode currA = headA;
            ListNode currB = headB;

            boolean endA = false;
            boolean endB =false;

            int countA = 0;
            int countB = 0;

            while(headA.val != headB.val && !endA  && !endB) {
                if (currA.val == currB.val) {
                    break;
                } else {
                    if(currA.next != null)
                        currA = currA.next;
                    else {
                        currA = headB;
                        if (countA == 1) {
                            currA = null;
                            endA = true;
                        }
                        countA++;
                    }
                    if(currB.next != null)
                        currB = currB.next;
                    else {
                        currB = headA;
                        if (countB == 1) {
                            endB = true;
                            currA = null;
                        }
                        countB++;
                    }
                }
            }
            return currA;
        }
    }


    //E169. Majority Element
    private static int majorityElement(int[] nums) {
        int major = 0;
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // E190. Reverse Bits
    private static int reverseBits(int n) {
        System.out.println(Integer.reverse(n));
        return Integer.reverse(n);
    }

    //E191. Number of 1 Bits
    private static int hammingWeight (int n){
        System.out.println(Integer.bitCount(n));
        return Integer.bitCount(n);
    }


    //203. Remove Linked List Elements
    private static ListNode removeElements(ListNode head, int val) {
        if(head == null )
            return null;

        ListNode myhead = new ListNode(0);
        myhead.next = head;
        head = myhead;

        while(myhead.next != null) {
            if(myhead.next.val == val)
                myhead.next =myhead.next.next;
            else
                myhead = myhead.next;
        }
        return head.next;
    }

    // E231,E326,E342. power of two, three or four
    private static boolean isPowerOfThree(int n) {
        System.out.println(Math.log(n) + " " + Math.log10(n));
        System.out.println(Math.log(3) + " " + Math.log10(3));
        System.out.println(Math.log(n)/Math.log(3) + " " + Math.log10(n)/Math.log10(3));

        return Math.log10(n)/Math.log10(3) % 1 == 0;
    }

    // 237. Delete node in a linked list
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // E344. Reverse String
    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 349. Intersection of Two Arrays
    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> mySet = new HashSet<Integer>();
        List<Integer> intersect = new ArrayList<Integer>();

        for(int n1: nums1) {
            mySet.add(n1);
        }

        for(int n2: nums2){
            if(mySet.contains(n2)){
                intersect.add(n2);
                mySet.remove(n2);
            }
        }

        int[] result = new int[intersect.size()];
        int count = 0;
        for(int i : intersect)
                result[count++] = i;

        return result;

    }
    // 350. Intersection of Two Arrays II
    private static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> myList = new ArrayList<Integer>();
        List<Integer> intersect = new ArrayList<Integer>();

        for(int n1: nums1)
            myList.add(n1);

        for(int n2: nums2){
            if(myList.contains(n2)){
                intersect.add(n2);
                myList.remove(myList.indexOf(n2));
            }
        }

        int[] result = new int[intersect.size()];
        int count = 0;
        for(int i : intersect)
            result[count++] = i;

        return result;
    }

    // main(test) function
    public static void main(String[] args) {

        //1. two Sum
        int[] test1 = {2,7,11,15};
        int target = 9;

        int[] result1 = twoSum(test1,target);
        System.out.println("SSS");
        for(int i = 0; i < result1.length;i++)
            System.out.println(result1[i]);
        System.out.println("SSS");
        // 19. Remove Nth Node From End of List
        /* test getLen */
        ListNode A  = new ListNode(1);
        ListNode B = new ListNode(3);
        ListNode C  = new ListNode(2);
        A.next = B;
        B.next = C;
        System.out.println(getLen(A));
        ListNode D = removeNthFromEnd(A,1);
        ListNode d = D;
        System.out.println("***");
        while(d != null) {
            System.out.println(d.val);
            d = d.next;
        }
        System.out.println("***");

        // 26. remove duplicate elements in array
        int[] num26 = {};
        System.out.println("^^^");
        System.out.println(removeDuplicates(num26));
        System.out.println("after");
        for(int i = 0; i < num26.length;i++)
            System.out.println(num26[i]);
        System.out.println("^^^");

        // 27. remove element
        int[] nums = {2};
        int newlen = removeElement(nums,2);
        System.out.println("---");
        System.out.println(newlen);
        for(int i = 0; i < nums.length;i++)
            System.out.println(nums[i]);
        System.out.println("---");
        //83.  remove duplicate elements in a list
        A.next = B;
        B.next = C;
        ListNode D83 = deleteDuplicates(A);
        System.out.println("666666");
        while(D83 != null) {
            System.out.println(D83.val);
            D83 = D83.next;
        }
        System.out.println("666666");
        // 160. Intersection of Two Linked Lists
        /* null */

        // 169. majority elements
        int[] num = {1,1,1,2,2};
        System.out.println(majorityElement(num));

        // 190. Reverse Bits
        reverseBits(43261596);

        // 191. Number of 1 bits
        hammingWeight(11);

        // 203 delete a node in a linked list
        ListNode iter = removeElements(A,1);
        System.out.println("+++");
        while(iter != null) {
            System.out.println(iter.val);
            iter = iter.next;
        }
        System.out.println("+++");
        //231,326,342. power of two, three or four
        isPowerOfThree((int)Math.pow((double)3,5));

        // 344. Reverse String
        String myS = "what the fuck !";
        System.out.println(reverseString(myS));

        // 349. Intersection of two arrays I
        int[] n1 = {1,2,2,1};
        int[] n2 = {2,2};
        int[] result349 = intersection(n1,n2);
        System.out.println("UUU");
        for(int i = 0; i < result349.length;i++)
            System.out.println(result349[i]);
        System.out.println("UUU");

        // 350. Intersection of two arrays II
        int[] result350 = intersect(n2,n1);
        System.out.println("ooo");
        for(int i = 0; i < result350.length;i++)
            System.out.println(result350[i]);
        System.out.println("ooo");
    }
}
