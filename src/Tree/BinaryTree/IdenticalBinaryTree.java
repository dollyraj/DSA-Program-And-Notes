package Tree.BinaryTree;

import Tree.TreeNode;

public class IdenticalBinaryTree {
    /*
    Problem Description

Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and
the nodes have the same value.

Solution Approach-
First we will check if the root node is equal that means null then yes.
if one of the root node is null then -> no
if both roots are not null but value does not match -> no
if both roots are not null and root values match
then we will recursively check if left subtrees are identical and right trees are identical
if yes then trees are identical

     */

    boolean identicalBinaryTree(TreeNode rootA,TreeNode rootB){
        if(rootA==rootB)
            return true;
        if(rootA==null || rootB==null)
            return false;
        if(rootA.val!= rootB.val)
            return false;

        boolean lst=identicalBinaryTree(rootA.left,rootB.left);
        boolean rst=identicalBinaryTree(rootA.right,rootB.right);
        return lst && rst;
    }
}
