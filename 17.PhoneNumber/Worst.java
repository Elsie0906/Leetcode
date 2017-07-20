public class Solution {
    public String LookUpTable(char character){
        String s = "";
        switch( character){
            case '2':
                s = s.concat("abc");
                break;
                
            case '3':
                s = s.concat("def");
                break;
                
            case '4':
                s = s.concat("ghi");
                break;
                
            case '5':
                s = s.concat("jkl");
                break;
                
            case '6':
                s = s.concat("mno");
                break;
                
            case '7':
                s = s.concat("pqrs");
                break;
                
            case '8':
                s = s.concat("tuv");
                break;
                
            case '9':
                s = s.concat("wxyz");
                break;
                
            default:
                break;
        }
        
        return s;
    }
    public List<String> append(int Count, int ArraySize, List<String> A){
        
        for(int i=ArraySize; i<Count; i++){
            A.add(i,"");
        }
        
        //System.out.println( "append: " + A);
        
        return A;
    }
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<String>();
        
        //System.out.println( "original content: " + digits + ", length: " + digits.length());
        
        if(digits.length() == 0) return result;
        
        String s1 = LookUpTable(digits.charAt(0));
        
        for(int i=0; i<s1.length(); i++){
            result.add(Character.toString(s1.charAt(i)));
        }
        
        //System.out.println( "s1: " + result );
        int arraySize, count;
        
        for(int i=1; i<digits.length(); i++)
        {
            String s2 = LookUpTable(digits.charAt(i));
            //System.out.println( "s2: " + s2 );
            
            arraySize = result.size();
            count = arraySize * s2.length();

            result = append(count, arraySize, result);
            
            for(int j=arraySize; j>0; j--){
                
                //String s3 = result.get(j-1);
                //System.out.println("combine s3: " + s3 );
                
                for(int z=s2.length(); z>0; z--){
                    
                    //String s4 = Character.toString(s2.charAt(z-1));
                    String s5 = "";
                    s5 = s5.concat(result.get(j-1));
                    s5 = s5.concat(Character.toString(s2.charAt(z-1)));
                    
                    //System.out.println("combine s5: " + s5 + " check s3: " + s3);
                    
                    result.set(count-1, s5);
                    
                    count--;
                    
                }
                
            }
            
        }

        
        return result;
    }
}