package com.wx.leetcode.hot;

import java.util.Deque;
import java.util.LinkedList;

public class H236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }
        return root;
    }

    public TreeNode createTree(int[] nums){
        if (nums==null||nums.length==0){
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        deque.add(root);
        boolean isLeft = true;
        for (int i = 1; i < nums.length ; i++) {
            TreeNode node = deque.peek();
            if (isLeft){
                if (nums[i]!=0){
                    TreeNode treeNode1 = new TreeNode(nums[i]);
                    node.left = treeNode1;
                    deque.add(treeNode1);
                }
                isLeft=false;
            }else {
                if (nums[i]!=0){
                    TreeNode treeNode1 = new TreeNode(nums[i]);
                    node.right = treeNode1;
                    deque.add(treeNode1);
                }
                deque.poll();
                isLeft=true;
            }
        }
        return root;
    }
}
