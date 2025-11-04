// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

// Given a string s, return true if it is a palindrome, or false otherwise.
class Solution {
    public boolean isPalindrome(String s) {
        String newStr=s.replaceAll( "[^a-zA-Z0-9]", "").toLowerCase();
        int l=0;
        int r=newStr.length()-1;

        while(l<r){
            if(newStr.charAt(l)!=newStr.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

// time:O(n)
// space:O(n)