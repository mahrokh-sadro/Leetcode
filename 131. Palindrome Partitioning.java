//131. Palindrome Partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        backtrack(list,new ArrayList<>(), s, 0);
        return list;
    }

    private void backtrack(List<List<String>> list,List<String> sublist,String s,int index){
        if(s.length()==index){
            list.add(new ArrayList<>(sublist));
        }

        for(int end=index;end<s.length();end++){
           if(isPalin(s,index,end)){
              sublist.add(s.substring(index,end+1));
              backtrack( list, sublist, s, end+1);
              sublist.remove(sublist.size()-1);
           }
        }
    }

    private boolean isPalin(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}