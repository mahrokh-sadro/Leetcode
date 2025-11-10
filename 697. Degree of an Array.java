// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.


class Solution {
    public int findShortestSubArray(int[] nums) {
        int n=nums.length;
        if(n==1){
            return n;
        }
        
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,int[]> indeces=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(!indeces.containsKey(nums[i])){
                indeces.put(nums[i],new int[2]);
                indeces.get(nums[i])[0] = i;
            }
            indeces.get(nums[i])[1] = i;

        }

        List<Map.Entry<Integer,Integer>> entries=new ArrayList<>(map.entrySet());

        entries.sort((e1,e2)->{
           return Integer.compare(e2.getValue(),e1.getValue() ); 
        });

        int min=Integer.MAX_VALUE;
        int max=entries.get(0).getValue();

        for(Map.Entry<Integer,Integer> entry:entries){
           if(entry.getValue()!=max) return min;
           int key=entry.getKey();
           min=Math.min( min, (indeces.get(key)[1] - indeces.get(key)[0]+1));
        }
        return min;


    }
}