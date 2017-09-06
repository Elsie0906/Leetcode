class Solution {
    public int squareSum(int number){
        int rem = number;
        int cal = 0;
        
        //System.out.println("number: "+ number);
        
        do{
            cal = cal + (int)Math.pow(rem%10,2);
            rem = rem/10 ;
            //System.out.println("cal: "+ cal + ", rem: " + rem);
        }while(rem != 0);
        
        return cal;
    }
    public boolean isHappy(int n) {
        boolean result = false;
        int sum = n;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // step1: sum of the squares of its digits
        // step2: check if the result repeated
        do
        {
            sum = squareSum(sum);
            if( list.contains(sum) == false)
                list.add(sum);
            else
                break;
        }while(sum != 1);
            
        if( sum == 1)
            result = true;
        
        return result;
    }
}