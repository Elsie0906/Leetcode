public class Solution {
    public boolean check(char[][] Array, int str_i, int str_j, String key){
        boolean Val = true;
        char left, right, up, down;
        int len = key.length(); 
        int index = 1;
        
        System.out.println("start point i: " + str_i + ", j: " + str_j);
        
        while(index < len){
            System.out.println("index: " + index); 
            if( str_j-1 >= 0){
                left = Array[str_i][str_j-1];
                System.out.println("left: " + left);
                if( left == key.charAt(index)){
                    index++;
                    str_j--;
                    continue;
                }
                //System.out.println("not a match! ");    
            }
                
            
            if( str_j+1 < Array[0].length){
                right = Array[str_i][str_j+1];
                System.out.println("right: " + right);
                if( right == key.charAt(index)){
                    index++;
                    str_j++;
                    continue;
                }
                //System.out.println("not a match! "); 
            }
                
            
            if( str_i-1 >=0){
                up = Array[str_i-1][str_j];
                System.out.println("up: " + up);
                if( up == key.charAt(index)){
                    index++;
                    str_i--;
                    continue;
                }
                //System.out.println("not a match! "); 
            }
                
            
            if( str_i+1 < Array.length){
                down = Array[str_i+1][str_j];
                System.out.println("down: " + down);
                if( down == key.charAt(index)){
                    index++;
                    str_i++;
                    continue;
                }
                //System.out.println("not a match! "); 
            }
               
            System.out.println("not a match! "); 
            return false;
        }
        
        return Val;
    }
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        int width = board.length;
        int height = board[0].length;
        boolean[][] map = new boolean[width][height];
        
        //System.out.println("width: "+ board.length + ", height: " + board[0].length);
        System.out.println("first char: " + word.charAt(0));
        char start = word.charAt(0);
        
        int i=-1, j=-1, count=0;
        while(count < width*height){
            i = count/height;
            j = count%height;
            //System.out.println("i: " + i + ", j: " + j);
            
            if( start == board[i][j])
                result = check(board, i, j, word);
            
            if( result == true)
                break;
            ++count;
        }
        
        return result;
    }
}