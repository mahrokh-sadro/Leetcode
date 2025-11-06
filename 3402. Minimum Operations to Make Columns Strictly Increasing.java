// You are given a m x n matrix grid consisting of non-negative integers.

// In one operation, you can increment the value of any grid[i][j] by 1.

// Return the minimum number of operations needed to make all columns of grid strictly increasing.


class Solution {
    public int minimumOperations(int[][] grid) {
        int total=0;
        int m=grid.length;
        int n=grid[0].length;
        
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]<=grid[i-1][j]){
                    int diff=grid[i-1][j]+1-grid[i][j];
                    total+=diff;
                    grid[i][j]+=diff;

                }
            }
        }
        return total;

    }
}