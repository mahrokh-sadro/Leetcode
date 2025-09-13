//986. Interval List Intersections

class Solution {
    public int[][] intervalIntersection(int[][] f, int[][] s) {
        int i=0,j=0;
        List<int[]> list=new ArrayList<>();
        
        while(i<f.length && j<s.length){
            int start=Math.max(f[i][0],s[j][0]);
            int end=Math.min(f[i][1],s[j][1]);

            if(start<=end){
                list.add(new int[]{start,end});
            }

            if(f[i][1]<s[j][1]){
                i++;
            }
            else{
                j++;
            }

        }

        return list.toArray(new int[list.size()][]);

    }
}