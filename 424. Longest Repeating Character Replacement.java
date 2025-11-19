// You are given a string s and an integer k. You can choose any character of the
// string and change it to any other uppercase English character. You can perform
// this operation at most k times.

// Return the length of the longest substring containing the same letter you can
// get after performing the above operations.

class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        if(n==1){
            return 1;
        }

        int max=0;
        int[] arr=new int[26];
        int l=0;
        int ocurrance=0;
        for(int r=0;r<n;r++){
            arr[s.charAt(r)-'A']++;
            ocurrance=Math.max(ocurrance,arr[s.charAt(r)-'A']); 

            if(r-l+1-ocurrance>k){
                arr[s.charAt(l)-'A']--;
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}