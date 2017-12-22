class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        // brute force
        int count = 0;
        int len = nums.length;
        
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    //System.out.println("[Debug] i: " + nums[i] + ",j: " + nums[j] + ", k: " + nums[k]);
                    int total = nums[i] + nums[j] + nums[k];
                    if(total < target)
                       count++; 
                }
            }
        }
        
        return count;
    }

}