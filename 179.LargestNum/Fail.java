import java.lang.*;

class Solution {
    public int comparison(String s1, String s2){
        int val = 0;
        
        System.out.println("comparison: s1 " + s1 + ", s2 " + s2); 
        
        for(int j=0; j<s1.length(); j++){
                
            System.out.println("comparison: c1 " + s1.charAt(j) + ", c2 " + s2.charAt(j)); 
            if( s1.charAt(j)>s2.charAt(j)){
                val = 1;                     // valueOf(s1) > valueOf(s2)
                break;   
            }
            else if(s1.charAt(j)<s2.charAt(j)){
                val = -1;
                break;
            }
        }        
        
        return val;
    }
    public String largestNumber(int[] nums) {
        String r1 = Integer.toString(nums[0]);
        
        for(int i=1; i<nums.length; i++){
            String r2 = Integer.toString(nums[i]);
            String v1 = r1.concat(r2);
            String v2 = r2.concat(r1);

            int cp = comparison(v1,v2);
            
            if( cp == 1)
                r1 = v1;
            else
                r1 = v2;
        
/*      Need a better method to compare!!!            
            Integer c1 = Integer.valueOf(v1);
            Integer c2 = Integer.valueOf(v2);
            
            if( c1>c2)
                r1 = v1;
            else
                r1 = v2;
*/                
        }
        
        return r1;
        
    }
}