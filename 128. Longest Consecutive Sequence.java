
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n<2) return n;

        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int cur=1;
            while(set.contains(++num)){
                cur++;
                set.remove(num);
            }

            num=nums[i];
            while(set.contains(--num)){
                cur++;
                set.remove(num);
            }
            max=Math.max(max,cur);
        }
        return max;
    }
}

// Time: O(n)
// Space: O(n)