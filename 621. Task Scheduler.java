//621. Task Scheduler

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