// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> merged=new ArrayList<>();
        merged.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] cur=intervals[i];
            int[] pre=merged.get(merged.size()-1);

            if(pre[1]>=cur[0]){
               pre[1]=Math.max(pre[1],cur[1]);
            }
            else{
               merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][]);

    }
}

// Time: O(nlogn)
// Space: O(n)