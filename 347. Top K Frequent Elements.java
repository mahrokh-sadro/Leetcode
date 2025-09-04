//347. Top K Frequent Elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->map.get(a)-map.get(b)
        );
        
        for(int num:nums){
          map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int num:map.keySet()){
            pq.add(num);

            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] ret=new int[k];
        int j=0;
        while(!pq.isEmpty()){
           ret[j++]=pq.poll();
        }

        return ret;

        
    }
}