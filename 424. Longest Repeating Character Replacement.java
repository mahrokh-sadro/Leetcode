424. Longest Repeating Character Replacement

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