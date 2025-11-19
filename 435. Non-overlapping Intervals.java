// Given an array of intervals intervals where intervals[i] = [starti, endi],
// return the minimum number of intervals you need to remove to make the rest
 //of the intervals non-overlapping.

// Note that intervals which only touch at a point are non-overlapping. 
//For example, [1, 2] and [2, 3] are non-overlapping.

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        List<int[]> merged=new ArrayList<>();
        merged.add(intervals[0]);
        int count=0;
        for(int i=1;i<intervals.length;i++){
            int[] cur=intervals[i];
            int[] pre=merged.get(merged.size()-1);

            if(pre[1]>cur[0]){
                count++;
            }
            else{
                merged.add(intervals[i]);
            }
        }

        return count;

    }
}