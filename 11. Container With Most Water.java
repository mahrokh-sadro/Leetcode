//11. Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int max=0;
        while(l<r){
            int cur=(r-l)* Math.min(height[l],height[r]);
            max=Math.max(max,cur);
            if(height[l]<height[r]){
                l++;
            }
            else{r--;}
        }
        return max;

    }
}