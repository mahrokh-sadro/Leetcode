//102. Binary Tree Level Order Traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        } 

        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> sublist=new ArrayList<>();
            for(int i=0;i<size;i++){
               var node=que.poll();
               
               if(node.left!=null){
                 que.add(node.left);
               }
               if(node.right!=null){
                 que.add(node.right);
               }

               sublist.add(node.val);
            }
            list.add(sublist);
        }

        return list;
    }
}