//567. Permutation in String

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }

        int[] arr1=new int[26];
        int[] arr2=new int[26];

        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(arr1,arr2)){
            return true;
        }


        int l=0;
        int r=s1.length();
        while(r<s2.length()){
            arr2[s2.charAt(l)-'a']--;
            arr2[s2.charAt(r)-'a']++;

            l++;
            r++;
            if(Arrays.equals(arr1,arr2)){
                return true;
            }
        }


        return false;
    }
}