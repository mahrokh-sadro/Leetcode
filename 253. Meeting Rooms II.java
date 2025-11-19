// You are given an array of meeting time intervals where each interval is represented as 
//intervals[i] = [start_i, end_i]. Each interval indicates when a meeting starts and ends.

// Your task is to find the minimum number of conference rooms required to schedule all 
//the meetings without any conflicts. In other words, if two or more meetings overlap in time,
// they need separate conference rooms.

// For example, if you have meetings [[0,30],[5,10],[15,20]], the first meeting runs from time 0 to 30.
// The second meeting (5 to 10) overlaps with the first, so you need a second room. The third meeting
// (15 to 20) also overlaps with the first, but since the second meeting has already ended by time 15,
// you can reuse that room. Therefore, you need a minimum of 2 conference rooms.
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
