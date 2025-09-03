//33. Search in Rotated Sorted Array

class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target,0,nums.length-1);
    }

    private int search(int[] nums, int target,int l,int r){
        if(l>r){
            return -1;
        }

        int mid=l+(r-l)/2;
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[l]<=nums[mid]){
            if(nums[l]<=target && target<=nums[mid]){
               return search(nums,target,l,mid-1);
            }
            else{
               return search(nums,target,mid+1,r);
            }
        }
        else{
            if(nums[mid]<=target && target<=nums[r]){
               return search(nums,target,mid+1,r);
            }
            else{
               return search(nums,target,l,mid-1);
            }
        }
    }
}