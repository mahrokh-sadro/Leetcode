//139. Word Break


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp=new Boolean[s.length()];
        return wordBreak( s,  wordDict,dp,0);
    }

    private boolean wordBreak(String s, List<String> wordDict,Boolean[] dp,int index) {
        if(s.length()==index){
            return true;
        }

        if(dp[index]!=null){
            return dp[index];
        }

        for(String word:wordDict){
            if(s.startsWith(word,index)){
                if(wordBreak(s, wordDict, dp, index+word.length())){
                    return true;
                }
            }
        }

        dp[index]=false;
        return false;

    }
}