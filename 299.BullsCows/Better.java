class Solution {
    public String getHint(String secret, String guess) {
        String str = "";
        
        // step 1: find 'A' -> compare one by one
        
        int numA = compare(secret, guess);    
        //System.out.println("numA: " + numA);
        
        // step 2: find 'B' -> using canonical form
        
        int[] cs = canonical(secret, guess);
        int[] cg = canonical(guess, secret);
        
        // check
        //printOut(cs);
        
        int numB = compare(cs, cg);
        
        //System.out.println("numB: " + numB);
        
        str = str + numA + "A" + numB + "B";
        
        return str; // dummy code
        
    }
    
    private int compare(int[] a, int[] b){
        int reVal = 0;
        
        for(int i=0; i<a.length; i++){
            if( a[i] != 0 && b[i] != 0){
                reVal = reVal + Math.min(a[i], b[i]);
            }
        }
        
        return reVal;
    }
    
    private int compare(String a, String b){
        // the secret number and your friend's guess only contain digits, and their lengths are always equal
        
        int val = 0;
        
        for(int i=0; i<a.length(); i++){
            if( a.charAt(i) == b.charAt(i)){
                val++;
            }
        }
        
        return val;
    }
    private int[] canonical(String str, String s){
        
        int[] array = new int[10];      // only digits, 0-9
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != s.charAt(i)){
                int val = Character.getNumericValue(str.charAt(i));
                array[val]++;
            }
        }
        
        return array;
    }
    private void printOut(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}