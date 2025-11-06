// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

// The test cases are generated so that there will be an answer.

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //sum=e/divisor +e2/divisor
        //sum<=thresh
        // int sum=0;
        // for(int num:nums){
        //     sum+= Math.ceil(num/divisor);
        // }
        Arrays.sort(nums);
        int l=1;
        int r=nums[nums.length-1];
        int divisor=0;
        while(l<r){
            divisor=l+(r-l)/2;
            if(canFinish(nums, threshold, divisor)){
               r=divisor;
            }
            else{
               l=divisor+1;
            }
        }
        return l;
    }

    private boolean canFinish(int[] nums, int threshold,int divisor){
        int sum=0;
        for(int num:nums){
            sum+= (num+divisor-1)/divisor;
        }

        return sum<=threshold;
    }
}
