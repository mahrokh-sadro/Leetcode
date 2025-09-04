//81. Search in Rotated Sorted Array II
class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums,target,0,nums.length-1);
    }

    private boolean search(int[] nums,int target, int l,int r){
        if(l>r){
            return false;
        }

        int mid=l+(r-l)/2;
        if(nums[mid]==target){
            return true;
        }
        if(nums[l]==nums[mid] && nums[mid]==nums[r]){
            return search(nums,target,l+1,r-1);
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

