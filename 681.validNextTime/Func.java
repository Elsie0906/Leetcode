class Solution {
    private int[] data = new int[4];    // HH:MM, only four digits
    
    private LinkedList<Integer> queue = new LinkedList<>();
    private ArrayList<LinkedList<Integer>> list = new ArrayList<>();
    
    public String nextClosestTime(String time) {
        
        getDigit(time);
        
        if( special() == true)
            return time;
        
        permute();
        
        return pick();
    }
    private void getDigit(String str){      // complexity: O(4)
        int idx = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if( Character.isDigit(c)){
                data[idx] = c - '0';
                idx++;
            }          
        }        
    }
    private boolean special(){              // ex. 00:00
        boolean reVal = true;
        int val = data[0];
        for(int i=1; i<data.length; i++){
            if( data[i] != val)
                return false;
        }
        return reVal;
    }
    private String pick(){
        
        int min = Integer.MAX_VALUE, max = 0;
        int minIdx = -1, maxIdx = -1;
        
        int ori_h = data[0]*10 + data[1];
        int ori_m = data[2]*10 + data[3];
             
        for(int i=0; i<list.size(); i++){
            LinkedList<Integer> p = list.get(i);
            //System.out.println("content of p: " + p); 
            int hr = popAndPush(p) * 10 + popAndPush(p);
            int m = popAndPush(p) * 10 + popAndPush(p);
            
            if( 0 <= hr && hr <= 23 && 0 <= m && m <= 59){
                int diff_h = (hr - ori_h);
                int diff_m = (m - ori_m);
                
                int diff = diff_h * 60 + diff_m;
                if( diff < min && diff > 0){
                    min = diff;
                    minIdx = i; 
                }
                
                if( diff < 0 && diff < max){
                    max = diff;
                    maxIdx = i;
                }
                
            }            
        }
        
        String str = "";
        
        int idx = -1;
        
        if( minIdx != -1){
            idx = minIdx;
        }
        else{
            idx = maxIdx;
        }
        
        LinkedList<Integer> q = list.get(idx);
        str = str + q.remove() + q.remove() + ":" + q.remove() + q.remove();
        return str;
    }
    private int popAndPush(LinkedList<Integer> p){
        int val = p.remove();
        p.add(val);
        return val;
    }
    private void permute(){         // complexity: O(4*4*4*4)
        
        if( queue.size() == data.length){
            //System.out.println("content of queue: " + queue);  
            LinkedList<Integer> q = new LinkedList<>();
            q.addAll(queue);
            list.add(q);   
            return;
        }
        
        for(int i=0; i<data.length; i++){
            queue.add(data[i]);
            //System.out.println("content of queue: " + queue);
            permute();
            queue.removeLast();
        }
    }
}