/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.LinkedList;
import java.util.List;

// leetcode 98: https://leetcode-cn.com/problems/validate-binary-search-tree/
public class ValidBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        solution(treeNode, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    // 1. 设定上下边界
    // 2. 中序遍历
    // 二叉搜索树定义: 左边的所有节点永远比右边的小
    public static boolean solution(TreeNode node, Integer max, Integer min) {
        if (node != null) {
            if(!solution(node.left, node.val, min)) {
                return false;
            }
            if ((null != max && node.val >= max) || (null != min && node.val <= min)) {
                return false;
            }
            return solution(node.right, max, node.val);
        }
        return true;
    }

}
