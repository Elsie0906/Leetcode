class Solution {
    public int hIndex(int[] citations) {
        // brute force
        if( citations.length == 0)
            return 0;
        // step1: find the range
        int max = -1;
        Arrays.sort(citations);
        
        // step2: find the max value of H-index
        for(int i=0; i<citations.length; i++){
            int count = citations.length - i;
            int val = citations[i];
            max = Math.max(max, Math.min(val, count));
        }
        
        return max;
    }
}