package Tree.BinaryTree;

import Tree.TreeNode;

/*
Question-
https://leetcode.com/problems/diameter-of-binary-tree/description/

Problem Description
--- Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is
the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.
The length of a path between two nodes is represented by
the number of edges between them.
---
Approach-
At any given node, the longest path that passes through it is the sum of the
height of its left subtree and the height of its right subtree.

For every node , we will calculate the diameter

At first glance, it seems the longest path always goes through the root — but it can pass through any node. So, for every node, we want to know:

The height of the left subtree

The height of the right subtree

The sum of these two gives the longest path through that node

We just need to find the maximum of all such paths.

Code idea->
Take height of lst and take height of rst
and consider the factor lst+rst+2 for each node

Brute force -->O(n^2),O(H)
Optimized--> we will calculate diameter while getting the height itself
TC-O(n),SC-O(H)
 */

public class DiameterOfBinaryTree {
    //int diameter=-1;

    int height(TreeNode root){
        if(root==null)
            return -1;

        int lh=height(root.left);
        int rh=height(root.right);

        //diameter=Math.max(diameter,lh+rh+2);

        return Math.max(lh,rh)+1;
    }

    public int getDiameter(TreeNode root){
        if(root==null)
            return -1;

        int lh=height(root.left);
        int rh=height(root.right);

        int ld=getDiameter(root.left);
        int rd=getDiameter(root.right);

        return Math.max(Math.max(ld,rd),lh+rh+2);
    }

}
