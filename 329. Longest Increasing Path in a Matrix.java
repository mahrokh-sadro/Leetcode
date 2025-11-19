// Given an m x n integers matrix, return the length of the
// longest increasing path in matrix.

// From each cell, you can either move in four directions:
// left, right, up, or down. You may not move diagonally
// or move outside the boundary (i.e., wrap-around is not allowed).

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int max=0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,dfs(matrix,dp,i,j));
            }
        }
        return max;
    }
    
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    private int dfs(int[][] matrix,int[][] dp,int r,int c){
        if(dp[r][c]!=0){
            return dp[r][c];
        }

        int max=1;
        for(int[] dir:directions){
           int x=dir[0]+r;
           int y=dir[1]+c;

           if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]>matrix[r][c]){
             max=Math.max(max,dfs(matrix,dp,x,y)+1);
           }
        }
        dp[r][c]=max; 
        return max;
    }
}