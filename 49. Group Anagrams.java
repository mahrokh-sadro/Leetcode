// Given an array of strings strs, group the together. You can return the answer in any order.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(String str:strs){
            char[] charKey=str.toCharArray();
            Arrays.sort(charKey);
            String key=new String(charKey);
            if(map.containsKey(key)){
               map.get(key).add(str);
            }
            else{
               map.put(key,new ArrayList<>());
               map.get(key).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }
}

// time:O(n × L log L)
// space:O(n × L)