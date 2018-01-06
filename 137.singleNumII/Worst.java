/*
  complexity: O(2*N), space: O(N)
*/
class Solution {
    public int singleNumber(int[] nums) {
        int reVal = -1;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], 1);
            }
            else{
                int count = hm.get(nums[i]);
                hm.put(nums[i], ++count);
            }
        }
        
        Set set = hm.entrySet();
        
        // Get an iterator
        Iterator i = set.iterator();
      
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            int count = (int)me.getValue();
            int val = (int)me.getKey();
            if(count == 1){
                return val; 
            }
        }
        
        return reVal;
    }
}