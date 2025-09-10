442. Find All Duplicates in an Array

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