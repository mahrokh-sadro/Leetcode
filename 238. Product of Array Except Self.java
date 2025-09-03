//238. Product of Array Except Self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] post=new int[n];
        pre[0]=1;
        post[n-1]=1;
        
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]* nums[i-1];
        }

        for(int j=n-2;j>=0;j--){
            post[j]=post[j+1]*nums[j+1];
        }

        for(int i=0;i<n;i++){
            pre[i]*=post[i];
        }

        return pre;
    }
}