//57. Insert Interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] arr=new int[n+1][2];
        for(int i=0;i<intervals.length;i++){
           arr[i]=intervals[i]; 
        }
        arr[n]=newInterval;
        
        Arrays.sort(arr , (a,b)->a[0]-b[0]);
        List<int[]> merged=new ArrayList<>();
        merged.add(arr[0]);

        for(int i=1;i<arr.length;i++){
           int[] cur=arr[i];
           int[] pre=merged.get(merged.size()-1);

           if(pre[1]>=cur[0]){
             pre[1]=Math.max(pre[1],cur[1]);
           }
           else{
             merged.add(arr[i]);
           }
        } 

        return merged.toArray(new int[merged.size()][]);


    }
}