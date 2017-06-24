/*
example: 
        input:[0] -> output:[1]
        input:[5] -> output:[6]
        input:[1,2,3] -> output:[1,2,4]
        input:[1,2,9] -> output:[1,3,0]
        input:[9] -> output:[1,0]
        input:[12] -> output: java assert
Fail:   out of range, don't use int/double for data storing
        input:[9,8,7,6,5,4,3,2,1,0]
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int array_len = digits.length;
        double ori_value = 0;
        double value = 0;
        boolean flag = true;
        
        for(int i=0; i<digits.length; i++)
        {
            ori_value = ori_value + digits[i]*Math.pow(10,digits.length-1-i);
            
            if( digits[i] != 9)
                flag = false;
        }
        
        // more digits to represent a number
        if( flag == true)
            array_len = digits.length + 1;
            
        int[] result = new int[array_len];    
        
        //System.out.println("original value:" + ori_value);
        
        value = ori_value + 1;
        //System.out.println("modified value:" + value);
        
        for(int i=array_len; i>0; i--)
        {
            //System.out.println("index:" + i);
            result[i-1] = (int)(value%10);
            //System.out.println("result:" + result[i-1]);
            value = value/10;
            //System.out.println("calculating:" + value);
        }
        
        
        return result;
    }
}