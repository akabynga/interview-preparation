package com.akabynga.leetcode;

import com.akabynga.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
//        Input: root = [1,null,2,3]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();

        visitNode(arrayList, root);

        return arrayList;
    }

    public static void visitNode(List<Integer> arrayList, TreeNode node) {
        if (node != null) {
            visitNode(arrayList, node.left);
            arrayList.add(node.val);
            visitNode(arrayList, node.right);
        }
    }

}