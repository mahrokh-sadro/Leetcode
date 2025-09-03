//16. 3Sum Closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[2];
        int minDiff=Math.abs(closestSum-target);
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                int diff=Math.abs(sum-target);

                if(diff<minDiff){
                    minDiff=diff;
                    closestSum=sum;
                }

                if(sum==target){
                  return sum;
                }
                else if(sum<target){
                  l++;
                }
                else{
                  r--;
                }
            }
        }
        return closestSum;
    }
}