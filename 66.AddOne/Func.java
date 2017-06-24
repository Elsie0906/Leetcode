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
        int[] result = new int[digits.length + 1];
        int LSB = digits[digits.length-1];
        boolean flag = false;

        // normal case: no extra bit, ex. input:[1] -> output:[2]
        if( LSB != 9){
            digits[digits.length-1] = digits[digits.length-1] + 1;
            return digits;
        }
        
        // no extra bit, but need to modified number; ex. input:[1,9] -> output:[2,0] or input:[2,9,9] -> output:[3,0,0]
        for(int i=digits.length; i>0; i--)
        {
            if( (digits[digits.length-1] == 9) || (flag == true && digits[i-1] == 9))
            {
                flag = true;
                digits[i-1] = 0;
            }
            else if( flag == true && digits[i-1] !=9)
            {
                flag = false;
                digits[i-1] = digits[i-1] + 1;
            }
        }
        
        // need extra bits, ex.input:[9,9] -> output:[1,0,0] 
        if(flag == true)
        {
            result[0] = 1;
            return result;
        }

        return digits;
    }
}