public class Solution {
    public boolean biSearch(int[] Array, int left, int right, int goal){
        int mid = 0;
        int len = right - left + 1;
        boolean reVal = false; 
        
        System.out.println("search range: " + left + " ~ " + right);
        
        if( Array[right] < goal)
            return false;
        
        if( len == 2 && Array[left]!=goal && Array[right]!= goal){
            return false;
        }
        
        if( len%2 == 1){
            mid = (left + right)/2;
        }
        else{
            mid = (left + right -1)/2;
        }
        
        if( Array[mid] > goal){
            right = mid;
            reVal = biSearch(Array, left, right, goal);
        }
        else if(Array[mid] < goal){
            left = mid;
            reVal = biSearch(Array, left, right, goal);
        }
        else if(Array[mid] == goal ){
            reVal = true;
        }
            
            
        return reVal;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allrows = new LinkedList<List<Integer>>();
         
        // let us print all the elements available in list
        //for (int number : candidates) {
        //    System.out.println("Number = " + number);
        //}      
        
        // sorting array
        Arrays.sort(candidates);        

        // let us print all the elements available in list
        System.out.println("The sorted int array is:");
        for (int number : candidates) {
            System.out.println("Number = " + number);
        }        

        // Phase 1: find the exact number, variable = 1
        int count = 0;
        
        for(int i=0; i<candidates.length; i++){
            if( candidates[i] >= target){
                count = i;
                if(candidates[i] == target){
                    LinkedList<Integer> row = new LinkedList<Integer>();
                    row.add(candidates[i]);
                    allrows.add(row); 
                }
                break;
            }
        }
        
        // search range: 0 ~ count-1
        
        // Phase 2: deal with smaller numbers

        int variables = target/candidates[0] + 1;
        
        System.out.println("calculated variables: " + variables);
        
        // variables = 2
        int choice = 0;
        int rem = 0;
        int min = candidates[0];
        boolean find = false;
        for(int i=0; i<count; i++){
            choice = candidates[i];
            rem = target - choice;
            
            if( rem >= min){
                find = biSearch(candidates, i, count-1, target);
            
                if( find == true){
                    LinkedList<Integer> row = new LinkedList<Integer>();
                    row.add(choice);
                    row.add(rem);
                    allrows.add(row);
                }                 
            }
        }
        
        
        
        return allrows;
    }
}