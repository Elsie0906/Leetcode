// Def of strobogrammatic:
// ex. 69, 619, 68189
// category: single word -> 0, 1, 8; pair -> 6, 9
// O(n)

class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] ori = new int[num.length()];         // original num
        Stack<Integer> st = new Stack<>();         // reverse num
        
        int number = 0;
        boolean err = false;
        
        for(int i=0; i<num.length() && !err; i++){
            
            number = num.charAt(i) - '0';
            
            ori[i] = number;
            
            switch(num.charAt(i)){
                case '6':
                    st.push(9);
                    break;
                case '9':
                    st.push(6);
                    break;
                case '0':
                case '1':
                case '8':
                    st.push(number);
                    break;
                default:
                    err = true;     
                    break;
            }     
        }
        
        if( err){
            //System.out.println("invalid number");
            return false;            
        }

        
        boolean result = true;
        // compare two numbers
        for(int i=0; i< ori.length; i++){
            if( ori[i] != st.pop()){
                //System.out.println("not equal");
                return false;    
            }
        }
        
        return result;
    }
}