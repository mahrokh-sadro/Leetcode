// You are given an array of integers stones where stones[i] is the weight of the ith stone.

// We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

//     If x == y, both stones are destroyed, and
//     If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.

// At the end of the game, there is at most one stone left.

// Return the weight of the last remaining stone. If there are no stones left, return 0.

class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        if(n==1) return stones[0];

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int stone:stones){
            pq.add(stone);
        }

        while(pq.size()>=2){
            int y=pq.poll();
            int x=pq.poll();

            pq.add(y-x);
        }
        return pq.size()==0? 0:pq.poll();
    }
}

// time:O(nlogn)
// space:O(n)











