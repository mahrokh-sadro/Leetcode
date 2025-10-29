//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Map.Entry<Integer,Integer>> entries=new ArrayList<>(map.entrySet());

        entries.sort((e1,e2)->{
            return Integer.compare(e2.getValue(),e1.getValue());
        });

        int[] array=new int[k];
        for(int i=0;i<k;i++){
            array[i]=entries.get(i).getKey();
        }

        return array;
    }
}

//Time:O(n + m log m)
//Space:O(n + k)