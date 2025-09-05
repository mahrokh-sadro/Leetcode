//435. Non-overlapping Intervals

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