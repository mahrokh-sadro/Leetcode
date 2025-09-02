//152. Maximum Product Subarray

class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int left=nums[0];
        int right=nums[n-1];
        int max=Math.max(left,right);
 
        for(int i=1;i<n;i++){
            left=left==0?nums[i]:nums[i]*left;
            right=right==0?nums[n-i-1]:nums[n-1-i]*right;
            max=Math.max( max,Math.max(left,right));
        }
        return max;
    }
}