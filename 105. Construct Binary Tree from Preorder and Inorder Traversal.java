//105. Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return createTree(map,preorder,0,preorder.length-1,0);
    }

    private TreeNode createTree(Map<Integer,Integer> map,int[] preorder,int l,int r,int rootIndex){
        if(l>r){
            return null;
        }

        TreeNode root=new TreeNode(preorder[rootIndex]);
        int mid=map.get(preorder[rootIndex]);

        root.left=createTree(map,preorder,l,mid-1,rootIndex+1);
        root.right=createTree(map,preorder,mid+1,r,rootIndex+(mid-l+1));
        
        return root;
    }
}
