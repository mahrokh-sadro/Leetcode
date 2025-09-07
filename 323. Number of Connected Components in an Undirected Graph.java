//323. Number of Connected Components in an Undirected Graph

class Solution {
    public int countComponents(int n, int[][] edges) {
         List<List<Integer>> graph=new ArrayList<>();
         for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
         }

         for(int[] edg:edges){
            graph.get(edg[0]).add(edg[1]);
            graph.get(edg[1]).add(edg[0]);
         }
         
         int count=0;
         boolean[] visited=new boolean[n];
         for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,visited,i);
                count++;
            }
         }

         return count;
    }

    private boolean dfs(List<List<Integer>> graph,boolean[] visited,int node){
         if(visited[node]){
            return true;
         } 

         visited[node]=true;
         for(var neighbor:graph.get(node)){
            dfs(graph,visited,neighbor);
         }
         return false;
    }







}
