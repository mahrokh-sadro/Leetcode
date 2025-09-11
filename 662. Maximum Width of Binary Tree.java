//662. Maximum Width of Binary Tree

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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> que=new LinkedList<>();
        que.add(new Pair<>(root,0));
        int max=0;

        while(!que.isEmpty()){
            int size=que.size();
            int startLevel=que.peek().getValue();
            int index=0;

            for(int i=0;i<size;i++){
                var pair=que.poll();
                TreeNode node=pair.getKey();
                index=pair.getValue();

                if(node.left!=null){
                   que.add(new Pair<>(node.left,index*2));
                }
                if(node.right!=null){
                   que.add(new Pair<>(node.right,index*2+1));

                }
                max=Math.max(max,index-startLevel+1);

            }
        }
        return max;
    }
}