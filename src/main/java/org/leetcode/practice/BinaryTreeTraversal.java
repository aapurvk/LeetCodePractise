package org.leetcode.practice;

import java.util.List;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        System.out.println(preorderTraversal(treeNode));
    }


     public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
     }

    public static List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }
}
