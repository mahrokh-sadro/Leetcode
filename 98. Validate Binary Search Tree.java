//8. Validate Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean isValid=true;
    TreeNode pre=null;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isValid;
    }

    private void dfs(TreeNode root){
        if(root==null){
            return;
        }

        dfs(root.left);
        if(pre!=null && pre.val>=root.val){
            isValid=false;
            return;
        }
        pre=root;

        dfs(root.right);

    }
}