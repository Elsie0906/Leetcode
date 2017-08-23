class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        int total = 0;
        final int len = gas.length;
        int[] aa = new int[len];
        int[] bb = new int[len];
        boolean[] mark = new boolean[len];
        
        //System.out.println("we have " + gas.length + " stations" );
        
        // step1: if the initialize value is negative, this node can't be the answer
        for(int i=0; i<len; i++){
            bb[i] = aa[i] = gas[i]-cost[i];
            total = aa[i] + total;
            //System.out.println("check1: gas " + gas[i] + " cost " + cost[i] + " aa " + aa[i]);
            if( aa[i] < 0)
                mark[i] = false;
            else
                mark[i] = true;
    
        }
        
        //System.out.println("total: " + total );
        
        // if total cumulative value is negative, we cannot travel around the circuit
        if( total < 0)
            return result;
        
        // Step2: a state machine for each node, reuse the value of next stop
        int index = -1;

        for(int row=1; row<len; row++){
            for(int i=0; i<len; i++){
                index = i+row;
                if( index >= len)
                    index = index - len;
                
                bb[i] = bb[i] + aa[index];
                
                if( mark[i] == true){
                    if( bb[i] < 0)
                        mark[i] = false;
                    else
                        result = i;
                }
            }
        }
               
        return result;
    }
}