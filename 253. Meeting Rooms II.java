//253. Meeting Rooms II
/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
         intervals.sort((a,b)->a.start-b.start);
         PriorityQueue<Integer> min=new PriorityQueue<>();
        for(Interval interval:intervals){
            if(!min.isEmpty() && interval.start>=min.peek()){
                min.poll();
            }
            min.add(interval.end);
         }   

         return min.size(); 

    }
}
