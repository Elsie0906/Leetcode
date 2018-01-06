/*
  complexity: O(N), space: O(2*N)
*/
class Solution {
    
    HashSet<Integer> hs = new HashSet<>();
    HashSet<Integer> set = new HashSet<>();
    
    public int singleNumber(int[] nums) {
        int reVal = -1;
        
        for(int i=0; i<nums.length; i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
                set.add(nums[i]);
            }
            else{
                set.remove(nums[i]);
            }
        }    
        
        Iterator iterator = set.iterator();
        
        if( iterator.hasNext())
            return (int)iterator.next();
        else
            return reVal;

    }
}