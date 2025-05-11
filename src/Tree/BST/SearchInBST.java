package Tree.BST;

import Tree.TreeNode;

public class SearchInBST {

    public boolean searchInBst(TreeNode root, int key){
        if(root==null)
            return false;

        if(root.val==key){
            return true;
        }else if(key>root.val){
            root=root.right;
        }else{
            root=root.left;
        }

        return true;
    }
}
