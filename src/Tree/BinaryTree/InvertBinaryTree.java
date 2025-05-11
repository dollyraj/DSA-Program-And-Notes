package Tree.BinaryTree;

import Tree.TreeNode;

public class InvertBinaryTree {

    /*
    https://leetcode.com/problems/invert-binary-tree/description/
    Given the root of a binary tree, invert the tree, and return its root.
    also known as mirror tree

    Solution- Recursive approach using preorder traversal
    First we swap the root values
    Now recursively invert left subtree and right subtree

    Try to implement iterative approach using level order traversal

     */

    public void invertBinaryTree(TreeNode root){

        if (root==null)
            return;

        //swap nodes
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

    }
}
