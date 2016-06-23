package com.company;

public class Main {
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
     }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        if(root == null || root == p || root == q)
            return curr;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right!= null)
            return root;
        return left == null ? right : left;
    }

    private static void test236() {
        TreeNode tn0 = new TreeNode(0);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(8);
        TreeNode tn9 = new TreeNode(9);

        tn3.left = tn5;
        tn3.right = tn1;
        tn5.right = tn2;
        tn5.left = tn6;
        tn2.right  = tn4;
        tn2.left = tn7;
        tn1.left = tn0;
        tn1.right = tn8;

        System.out.println(lowestCommonAncestor(tn3,tn6,tn0).val);
    }

    public static void main(String[] args) {
	// write your code here
        test236();
    }
}
