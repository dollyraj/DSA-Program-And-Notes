package Tree.BinaryTree;

public class DiameterOfBinaryTree {
    int diameter=-1;

    int height(TreeNode root){
        if(root==null)
            return -1;

        int lh=height(root.left);
        int rh=height(root.right);

        diameter=Math.max(diameter,lh+rh+2);

        return Math.max(lh,rh)+1;
    }
}
