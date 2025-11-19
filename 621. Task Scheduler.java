//You are given an array of CPU tasks, each labeled with a letter from A to Z,
// and a number n. Each CPU interval can be idle or allow the completion of one task.
// Tasks can be completed in any order, but there's a constraint: there has to be a gap
// of at least n intervals between two tasks with the same label.

//Return the minimum number of CPU intervals required to complete all tasks.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int ch:tasks){
           freq[ch-'A']++;
        }

        Arrays.sort(freq);
        int maxFreq=freq[25];
        int maxFreqCount=1;

        for(int i=24;i>=0;i--){
            if(maxFreq==freq[i]){
                maxFreqCount++;
            }
        }

        int partitions=(n+1)*(maxFreq-1)+maxFreqCount;

        return Math.max( tasks.length, partitions);

    }
}