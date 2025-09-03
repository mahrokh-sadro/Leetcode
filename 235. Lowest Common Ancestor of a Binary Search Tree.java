//235. Lowest Common Ancestor of a Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var cur=root;
        while(cur!=null){
            if(cur.val>p.val && cur.val>q.val){
                cur=cur.left;
            }
            else if(cur.val<p.val && cur.val<q.val){
                cur=cur.right;
            }
            else{
                return cur;
            }
        }
        return cur;
    }
}