class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int val1 = 0, val2 = 0;
        int idx1 = 0, idx2 = 0;
        
        // brute force: (n-1) + (n-2) + ... + 1 = O(n^2)
        
        for(int i=0; i<numbers.length; i++){
            val1 = numbers[i];
            idx1 = i;
            
            if( i+1<numbers.length && val1 == 0 && target != 0)
                continue;
            
            for(int j=i+1; j<numbers.length; j++){
                val2 = numbers[j];
                idx2 = j;
                
                if( val1 + val2 == target)
                    break;
            }
            
            if( val1 + val2 == target)
                break;
        }
        
        // Please note that your returned answers (both index1 and index2) are not zero-based
        result[0] = idx1 + 1;
        result[1] = idx2 + 1;
        
        return result;
    }
}