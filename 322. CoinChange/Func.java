import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //System.out.println("coins: " + coins.length + "amount: " + amount);
        
        Arrays.sort(coins);
        
        if( amount == 0)
            return 0;
        
        int[] lookUp = new int[amount+1];     

        
        
        // initialize, fills with infinite num
        
        Arrays.fill(lookUp, 999);
        
        for(int iter=0; iter<coins.length; iter++){
            int count = amount/coins[iter];
            for(int i=1; i<=count; i++){
                int val = i * coins[iter];
                lookUp[val] = i;
            }
        }        

        
        lookUp[0] = 0; // amount = 0
        
        for(int iter=1; iter<coins.length; iter++){
            for(int i=0; i<lookUp.length; i++){
                // coins[iter] != 0
                int rem1 = i - coins[iter];
                if(rem1 >= 0)
                   lookUp[i] = Math.min(1+lookUp[rem1], lookUp[i]);
                int rem2 = i - coins[iter-1];
                if(rem2 >= 0)
                   lookUp[i] = Math.min(1+lookUp[rem2], lookUp[i]);
                
                // check
                //System.out.println("val: " + i + ", lookUp:" + lookUp[i]);      
            }
        }
     
        //System.out.println("lookUp: " + lookUp[amount]);
        
        if( lookUp[amount] == 999)
            return -1;
        
        return lookUp[amount]; // dummy code
    }
}