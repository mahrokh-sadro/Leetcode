//103. Binary Tree Zigzag Level Order Traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        int level=0;
        while(!que.isEmpty()){
           int size=que.size();
           level++;
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
            if(level%2==0){
                Collections.reverse(sublist);
             }
           list.add(sublist);
        }
        return list;
    }
}