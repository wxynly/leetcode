package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class H102 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs1(root, 0);
        return res;
    }

    public void bfs1(TreeNode root, Integer deep) {
        if (root == null) {
            return;
        }
        //递归一次深度+1
        deep++;
        //如果size<deep，说明这一层还未遍历过，新建空结果集
        if (res.size() < deep) {
            res.add(new ArrayList<>());
        }
        //添加进这一层的结果集
        res.get(deep - 1).add(root.val);
        bfs1(root.left, deep);
        bfs1(root.right, deep);
    }

    public void bfs2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);
        while (deque.size() > 0) {
            int len = deque.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            res.add(list);
        }
    }

}
