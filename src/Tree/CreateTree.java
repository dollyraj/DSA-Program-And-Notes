package Tree;

import Tree.BinaryTree.DiameterOfBinaryTree;

public class CreateTree {

    public static TreeNode createTree(TreeNode root){
        // Constructed binary tree is
        //          5
        //        /   \
        //       8     6
        //      / \   /
        //     3   7 9
       // Node root = new Node(5);
        root.left = new TreeNode(8);
        //root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
       // root.right.left = new TreeNode(9);
        root.left.left.left=new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        return root;
    }

    public static void main(String[] args) {
        TreeNode  root=createTree(new TreeNode(5));
        DiameterOfBinaryTree diameterOfBinaryTree=new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.getDiameter(root));
    }
}
