// There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

// The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

// The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

// Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
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