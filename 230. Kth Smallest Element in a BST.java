//230. Kth Smallest Element in a BST

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
    int val=0;
    int index=0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return val;
    }

    private void dfs(TreeNode root, int k){
        if(root==null){
            return;
        }

        dfs(root.left,k);
        index++;
        if(index==k){
            val=root.val;
            return;
        }
        dfs(root.right,k);
    }
}