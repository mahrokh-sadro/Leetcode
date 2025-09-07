//261. Graph Valid Tree
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        } 

        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
           graph.add(new ArrayList<>());  
        }

        for(int[] edg:edges){
            graph.get(edg[0]).add(edg[1]);
            graph.get(edg[1]).add(edg[0]);
        }

        boolean[] visited=new boolean[n];  
        if(dfs(graph, 0,-1,visited)){
            return false;
        }

        for(boolean v:visited){
            if(!v){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int node,int parent,boolean[] visited){
        if(visited[node]){
            return true;
        }  
        
        visited[node]=true;
        for(var neighbor: graph.get(node)){
            if(neighbor==parent) continue;
            if(dfs(graph, neighbor,node,visited)){
                return true;
            }
        }

        return false;
    }
}
