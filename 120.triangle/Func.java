class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        //System.out.println("layer: " + triangle.size() + " number: " + triangle.get(0).size());
        dp[0] = triangle.get(0).get(0);
        
        int layer;
        int N=0,pre=0,cur=0,val=0;
        for(layer=1; layer<triangle.size(); layer++){
            //System.out.println("layer: " + layer);
            N = triangle.get(layer).size();
            for(int num=0; num<N; num++){
                if( num!=0 && num != N-1){
                    pre = Math.min(triangle.get(layer-1).get(num),triangle.get(layer-1).get(num-1));
                    cur = triangle.get(layer).get(num);    
                    val = pre+cur;
                }
                else if(num == 0){
                    pre = triangle.get(layer-1).get(num); 
                    cur = triangle.get(layer).get(num);
                    val = pre+cur;
                    dp[layer] = val;
                }
                else{
                    pre = triangle.get(layer-1).get(num-1); 
                    cur = triangle.get(layer).get(num);
                    val = pre+cur;
                }
                //System.out.println("pre: "+pre + " cur: "+ cur+ " val: "+val);
                List<Integer> ll = triangle.get(layer);
                ll.set(num, val);
                
                if( dp[layer]> val)
                    dp[layer] = val;
                
                //System.out.println("dp: "+ dp[layer]);
            }
        }
        
        //System.out.println("dp:" + dp[layer] + " layer: " + layer);
        
        return dp[layer-1];
    }
    
}