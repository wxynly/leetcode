package com.wx.leetcode.hot;

import java.util.HashMap;
import java.util.Map;

//打家劫舍 III
public class H337 {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        //记忆化搜索，如果之前计算过直接返回
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        }
        //从父节点开始偷，下一个为子节点的左右节点
        int val1 = root.val;
        if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        //从左右子节点开始偷
        int val2 = rob(root.left) + rob(root.right);
        int max = Math.max(val1, val2);
        map.put(root, max);
        return max;
    }

    public int rob2(TreeNode root) {
        int[][] result = robTree(root);
        return Math.max(result[0][0], result[0][1]);
    }

    //result[0][0] 代表当前节点不偷的最大值 result[0][1] 代表当前节点偷的最大值
    public int[][] robTree(TreeNode root) {
        if (root == null) {
            return new int[][]{{0, 0}};
        }
        //计算左、右节点
        int[][] leftResult = robTree(root.left);
        int[][] rightResult = robTree(root.right);
        //当前节点值
        int[][] result = new int[1][2];
        //当前节点不偷，最大值为偷其左节点最大值+右子节点最大值，但左右节点也可选择偷或不偷，选出偷或不偷的最大值
        result[0][0] = Math.max(leftResult[0][0], leftResult[0][1]) + Math.max(rightResult[0][0], rightResult[0][1]);
        //当前节点偷，最大值为当前值+左节点不偷+右节点不偷
        result[0][1] = root.val + leftResult[0][0] + rightResult[0][0];
        return result;
    }
}
