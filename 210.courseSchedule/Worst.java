class Solution {
    private ArrayList[] table;
    private int[] count;
    private ArrayList<Integer> hs = new ArrayList<Integer>();
    public int[] list;
    private int num = 0;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // return a list of course
        
        createTable(numCourses, prerequisites);
        
        //printOut();
        
        for(int i=0; i<numCourses; i++){
            pick();
            //printOut();
        }        
        
        int[] empty = {};
        if( hs.size() != numCourses)
            return empty; 
              
        return list;
    }
    private void pick(){
               
        for(int i=0; i<count.length; i++){
            if( count[i] == 0){              // find zero num of prerequisites
                hs.add(i);
                list[num++] = i;
                count[i] = Integer.MAX_VALUE;
                ArrayList<Integer> bucket = table[i];
                
                if( bucket == null){
                    break;
                }
                    
                
                for(int j=0; j<bucket.size(); j++){
                    int idx = bucket.get(j);
                    count[idx]--;
                }
                break;
            }              
        }        
        
    }
    private void printOut(){
        
        for(int i=0; i<table.length; i++){
            System.out.println(table[i]);
        }
        
        System.out.print("count: ");
        for(int i=0; i<count.length; i++){
            System.out.print(count[i] + " ");
        }
        System.out.println();
    }
    private void createTable(int numCourses, int[][] prerequisites){
        
        // create a table (just like hashtable)
        table = new ArrayList[numCourses];
        count = new int[numCourses];
        list = new int[numCourses];
        
        //System.out.println("prerequisties width: " + prerequisites.length + ", hight: " + prerequisites[0].length);
        //System.out.println("table: " + (table[0]==null));
        
        int pre = -1, cur = -1;
        for(int i=0; i<prerequisites.length; i++){
            pre = prerequisites[i][1];
            cur = prerequisites[i][0];
            
            count[cur]++;
            
            if( table[pre] == null){
                // create a linked list
                ArrayList<Integer> bucket= new ArrayList<Integer>();
                bucket.add(cur);
                table[pre] = bucket;
            }
            else{
                ArrayList<Integer> bucket= table[pre];
                bucket.add(cur);
                table[pre] = bucket;
            }
            
        }        
    }
}