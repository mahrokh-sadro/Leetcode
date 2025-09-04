//417. Pacific Atlantic Water Flow
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;

        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(heights,pacific,i,0,heights[i][0]);
            dfs(heights,atlantic,i,n-1,heights[i][n-1]);
        }

        for(int j=0;j<n;j++){
            dfs(heights,pacific,0,j,heights[0][j]);
            dfs(heights,atlantic,m-1,j,heights[m-1][j]);
        }
        
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }

    private void dfs(int[][] heights,boolean[][] visited,int r,int c,int preHeight){
        if(r<0 || r>=heights.length || c<0 || c>=heights[0].length || visited[r][c] ||
           heights[r][c]<preHeight){
           return;
        }

        visited[r][c]=true;
        dfs(heights,visited,r+1,c,heights[r][c]);
        dfs(heights,visited,r-1,c,heights[r][c]);
        dfs(heights,visited,r,c+1,heights[r][c]);
        dfs(heights,visited,r,c-1,heights[r][c]);

    }
}