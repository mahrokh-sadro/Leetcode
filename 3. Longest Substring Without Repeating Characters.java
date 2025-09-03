//3. Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            int index=s.indexOf(s.charAt(i),l);
            if(index!=i){
                l=index+1;
            }
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}