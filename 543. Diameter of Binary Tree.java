// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        getDepth(root);
        return max;
    }
    int max=0;
    private int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        max= Math.max(max,left+right);

        return Math.max(left,right)+1;
    }
}
//time:O(n)
//space:O(h), i.e. O(log n) for balanced, O(n) for skewed