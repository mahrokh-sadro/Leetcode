//210. Course Schedule II

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
                return new int[0];
            }
        }

        int[] arr=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }

        return arr;
    }
    
    List<Integer> list=new ArrayList<>();
    private boolean dfs(List<List<Integer>> graph,int[] visited,int node){
        if(visited[node]==1){
          return true;
        }

        if(visited[node]==2){
          return false;
        }

        visited[node]=1;
        for(var neighbor:graph.get(node)){
          if(dfs(graph,visited,neighbor)){
            return true;
          }
        }
        list.add(0,node);
        visited[node]=2;
        return false;
    }
}