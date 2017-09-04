import java.lang.*;

class Solution {
    public String arrayListToString(List<Integer> List){
        
        String s1 = "";
        for(int i=0; i<List.size(); i++){
            s1 = s1.concat(Integer.toString(List.get(i)));
        }        
        return s1;
        
    }
    public int comparison(String a, String b){
        int val = 0;

        //System.out.println("string a = " + a + ", b = " + b);
        
        for(int j=0; j<a.length(); j++){
                
            if( a.charAt(j) > b.charAt(j))
                return 1;
            else if(a.charAt(j) < b.charAt(j))
                return -1;
        }        
        
        return val;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        // Disadvantage: input = [1,1,1]
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } 
        else{
            for(int i = 0; i < nums.length; i++){ 
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }     
    public String largestNumber(int[] nums) {
        String r1 = "";
        // step1: list all possible ans
        
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        
        // step2: convert it to be a string
        // step3: compare all possible ans, and find the maximum
        
        int check = 0;
        
        //System.out.println("list.size() = " + list.size());
        
        if( list.size() == 0){
            for(int i=0; i<nums.length; i++){
                String r2 = Integer.toString(nums[i]);
                r1 = r1.concat(r2);
            }            
            return r1;
        }
        
        String x1 = arrayListToString(list.get(0));
        
        for(int i=1; i<list.size(); i++){
            
            String x2 = arrayListToString(list.get(i));
            
            check = comparison(x1,x2);
            
            if( check == 1)   // x1 > x2
                x1 = x1;
            else
                x1 = x2;
        }      
        
        //System.out.println("string x1 " + x1);
        
        r1 = x1;
        
        return r1;
        
    }
}