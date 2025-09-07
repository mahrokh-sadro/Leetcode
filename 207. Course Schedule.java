//207. Course Schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
           graph.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        
        int[] visited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(graph,visited,i)){
                return false; 
            }
        }

        return true;

    }

    private boolean dfs(List<List<Integer>> graph,int[] visited,int node){
        if(visited[node]==1){
          return true;
        }

        if(visited[node]==2){
          return false;
        }

        visited[node]=1;
        for(int neighbor: graph.get(node)){
           if(dfs(graph, visited, neighbor)){
             return true;
           }
        }
        visited[node]=2;
        return false;
    }
}