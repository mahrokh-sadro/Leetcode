//17. Letter Combinations of a Phone Number

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.length()==0){
            return list;
        }
        String[] keypad=new String[10];

        keypad[2]="abc";
        keypad[3]="def";
        keypad[4]="ghi";
        keypad[5]="jkl";
        keypad[6]="mno";
        keypad[7]="pqrs";
        keypad[8]="tuv";
        keypad[9]="wxyz";

        backtrack(list,keypad,digits,0,new StringBuilder());

        return list;
    }

    private void backtrack(List<String> list,String[] keypad,String digits,int index,StringBuilder cur){
        if(cur.length()==digits.length()){
            list.add(cur.toString());
            return;
        } 

        String letters=keypad[digits.charAt(index)-'0'];
        for(int i=0;i<letters.length();i++){
            cur.append(letters.charAt(i));
            backtrack(list, keypad, digits, index+1, cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }


}