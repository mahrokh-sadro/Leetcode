// Given a string s, sort it in decreasing order based on the frequency of the characters. 
//The frequency of a character is the number of times it appears in the string.

// Return the sorted string. If there are multiple answers, return any of them.


class Solution {
    public String frequencySort(String s) {
        //desc freq of chars
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        List<Map.Entry<Character,Integer>> entries=new ArrayList<>(map.entrySet());
        
        entries.sort((e1,e2)->{
           return Integer.compare(e2.getValue(),e1.getValue());
        });

        StringBuilder sb=new StringBuilder();
        for(var entry:entries){
            for(int i=0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }

        return sb.toString();

    }
}

// time: O(n + u log u + n) = O(n + u log u) → effectively O(n) for ASCII
// space:O(u + n) → effectively O(n) for ASCII (map + output string)