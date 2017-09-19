// Def of strobogrammatic:
// ex. 69, 619, 68189
// category: single word -> 0, 1, 8; pair -> 6, 9
// O(n)

class Solution {
    public boolean isStrobogrammatic(String num) {
        int left, right;
        left = 0;
        right = num.length()-1;
    
        while(left<=right) {
            if(!isGood(num.charAt(left), num.charAt(right)))
                return false;
                left++;
                right--;
        }
        return true;
    }

    public boolean isGood(char a, char b) {
        if( (a=='1'&&b=='1') || (a=='6'&&b=='9') || (a=='9'&&b=='6') || (a=='8'&&b=='8')  || (a=='0'&&b=='0') )
            return true;
        return false;
    }
}