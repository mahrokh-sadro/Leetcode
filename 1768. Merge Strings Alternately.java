// You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

// Return the merged string.

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        int m=word1.length();
        int n=word2.length();
        StringBuilder sb=new StringBuilder();

        while(i<m && j<n){
            sb.append(word1.charAt(i)).append(word2.charAt(j));
            i++;
            j++;
        }

        while(i<m){
           sb.append(word1.charAt(i));
           i++;
        }

        while(j<n){
           sb.append(word2.charAt(j));
           j++;
        }

        return sb.toString();
    }
}