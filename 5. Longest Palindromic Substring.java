//Given a string s, return the longest in s.

class Solution {
    public String longestPalindrome(String s) {
        String longest="";
        for(int i=0;i<s.length();i++){
            String s1=getPalin(s,i,i);
            String s2=getPalin(s,i,i+1);
            if(longest.length()<s1.length()){
              longest=s1;
            }
            if(longest.length()<s2.length()){
              longest=s2;
            }
        }
        return longest;
    }

    private String getPalin(String s,int l,int r){

        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        l++; 
        return s.substring(l,r);
    }
}