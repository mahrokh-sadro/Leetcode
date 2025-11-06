// You are given a 0-indexed array of strings words and a 2D array of integers queries.

// Each query queries[i] = [li, ri] asks us to find the number of strings present at the indices ranging from li to ri (both inclusive) of words that start and end with a vowel.

// Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

// Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.


class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int[] prefix=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i];
            String s=words[i];
            if(isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1))){
                 prefix[i+1]++;
            }
        }

        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            ans[i]=prefix[r+1]-prefix[l];
        }
        return ans;
    }

    private boolean isVowel(char ch){
        return "aeuio".indexOf(ch)>=0;
    }
}