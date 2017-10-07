class Solution {
    public boolean isUgly(int num) {
        //System.out.println("num: " + num);
        if( num <= 0)
            return false;
        
        if( num <= 6){
            //System.out.println("[DEBUG] num <= 6");
            return true;
        }

        if( num%2 == 0)
            return isUgly(num/2);
        else if(num%3 == 0)
            return isUgly(num/3);
        else if(num%5 == 0)
            return isUgly(num/5);
        else
            return false;
       
    }
}