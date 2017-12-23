class Solution {
    public int hIndex(int[] citations) {
        // brute force
        // step1: find the range
        int max = -1;
        for(int i=0; i<citations.length; i++){
            if( citations[i] > max)
                max = citations[i];
        }
        
        int idx = 0;
        for(int i=0; i<=max; i++){
            int count = 0;
            for(int j=0; j<citations.length; j++){
                if( citations[j] >= i)
                    count++;
            }
            //System.out.println("[Debug] i: " + i + ", count: " + count);
            if( count >= i && i > idx)
                idx = i;
        }
        
        return idx;
    }
}