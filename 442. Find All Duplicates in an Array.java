// Given an integer array nums of length n where all the integers of nums are in the range [1, n]
// and each integer appears at most twice, return an array of all the integers that appears twice.

// You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
// excluding the space needed to store the output

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       int i=0;
       int n=nums.length;
       while(i<n){
          int expectedIndex=nums[i]-1;
          if(nums[expectedIndex]!=nums[i]){
             int temp=nums[expectedIndex];
             nums[expectedIndex]=nums[i];
             nums[i]=temp;
          }
          else{
            i++;
          }
       } 
       
       List<Integer> list=new ArrayList<>();
       for(int j=0;j<nums.length;j++){
         if(nums[j]!=j+1){
            list.add(nums[j]);
         }
       }

       return list;
    }
}