package Tree;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
