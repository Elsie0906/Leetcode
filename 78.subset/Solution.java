class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> emp = new ArrayList<Integer>();
        result.add(emp);
        
        if (nums.length == 0) return result;
               
        for (int i = 0; i < nums.length; i++) {
            
            int n = result.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> sub = (ArrayList<Integer>) result.get(j);
                List<Integer> subc = (ArrayList<Integer>) sub.clone(); // copy of sub
                subc.add(nums[i]);
                result.add(subc);
            }
            
        }
        return result;        
    }
}