class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            if( !hm.containsKey(val))
                hm.put(val, i);         // <val, idx>
            else{
                int idx = hm.get(val);
                int dist = i-idx;
                if( dist <= k)
                    return true;
                else
                    hm.put(val,i);
            }  
        }
        
        return false;
    }
}