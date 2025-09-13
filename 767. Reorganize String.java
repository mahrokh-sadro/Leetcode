//767. Reorganize String


class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        Map<Character,Integer> freq=new HashMap<>();
        for(char ch:s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            if(freq.get(ch)>(n+1)/2){
                return "";
            }
        }

        PriorityQueue<Character> pq=new PriorityQueue<>(
            (a,b)->freq.get(b)-freq.get(a)
        );

        pq.addAll(freq.keySet());
        StringBuilder sb=new StringBuilder();
        while(pq.size()>=2){
            char first=pq.poll();
            char second=pq.poll();

            sb.append(first).append(second);
            freq.put(first,freq.get(first)-1);
            freq.put(second,freq.get(second)-1);

            if(freq.get(first)>0) pq.offer(first);
            if(freq.get(second)>0) pq.offer(second);
        }

        if(!pq.isEmpty()){
            sb.append(pq.poll());
        }

        return sb.toString();


    }
}