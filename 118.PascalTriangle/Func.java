import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        
        if(numRows == 0) return allrows;
        
        if( numRows >= 1){
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            allrows.add(row);            
        }

        if( numRows >= 2 ){
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(0,1);
            row.add(1,1);
            allrows.add(1,row);
        }
        
        // for numRows > 2
        if( numRows > 2){
            for(int i=2; i<numRows; i++){
                //System.out.println("Current row: "+ i);
                int z = i-1;
                //System.out.println("Previous row: "+ z); 
                
                //for ( Integer number : allrows.get(z)) {
                //        System.out.println("Number = " + number);
                //}                 
                
                ArrayList<Integer> row = new ArrayList<Integer>();
                row.add(0,1);
                
                // Find value  
                for(int j=1; j<i; j++){
                    //System.out.println("index: "+ j);
                    int temp = allrows.get(z).get(j) + allrows.get(z).get(j-1);
                    row.add(j,temp);    
                }
                
                row.add(i,1);         
                
                allrows.add(i,row);
            }            
        }

        
        return allrows;
    }
}