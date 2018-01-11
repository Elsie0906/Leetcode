class Solution {
    public List<List<Integer>> list = new LinkedList<>();
    private List<Integer> q = new LinkedList<>();
    private HashSet<List<Integer>> hs = new HashSet<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        helper(nums, 0);
        
        return list;
        
    }
    
    private void helper(int[] nums, int idx){
        
        if( nums.length == q.size()){
            List<Integer> queue = new LinkedList<>();
            queue.addAll(q);

            if(!hs.contains(queue))   // LinkedList.contains() costs O(n) for each search
            {
                hs.add(queue);
                list.add(queue);
            }
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if( nums[i] != Integer.MIN_VALUE){
                int val = nums[i];
                nums[i] = Integer.MIN_VALUE;
                q.add(val);
                helper(nums, ++idx);
                q.remove(--idx);
                nums[i] = val;
            }

        }
        
    }
}