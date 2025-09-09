208. Implement Trie (Prefix Tree)

class Trie {

    Trie[] children;
    boolean isWord;
    public Trie() {
        children=new Trie[26];
        isWord=false;
    }
    
    public void insert(String word) {
        var cur=this;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(cur.children[ch-'a']==null){
                cur.children[ch-'a']=new Trie();
            }
            cur=cur.children[ch-'a'];
        }
        cur.isWord=true;
    }
    
    public boolean search(String word) {
        var cur=this;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(cur.children[ch-'a']==null){
                return false;
            }
            cur=cur.children[ch-'a'];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        var cur=this;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(cur.children[ch-'a']==null){
                return false;
            }
            cur=cur.children[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */