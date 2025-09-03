//213. House Robber II


class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }

        int left=rob(nums,0,n-2);
        int right=rob(nums,1,n-1);

        return Math.max(left,right);
    }

    private int rob(int[] nums,int l,int r){
        int n=r-l+1;
        if(n==0){
          return 0;
        }
        if(n==1){
          return nums[l];
        }
        if(n==2){
          return Math.max(nums[l],nums[l+1]);
        }

        int[] dp=new int[n+1];
        dp[1]=nums[l];
        dp[2]=Math.max( nums[l],nums[l+1]);

        for(int i=3;i<n+1;i++){
           dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i+l-1]);
        }

        return dp[n];
    }
}