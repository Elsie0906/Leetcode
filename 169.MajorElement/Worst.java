class Solution {
    public int majorityElement(int[] nums) {
        int result = -1;
        Node head = new Node(nums[0], 1);
        Node pp;
        boolean mark = false;
        
        //System.out.println("head: "+ head);
        for(int i=1; i<nums.length; i++){
            //System.out.println("value: "+ nums[i]);
            pp = head;
            mark = false;
            
            while(pp.next != null){
                //System.out.println("head: "+ head + "node: "+pp + "next: "+ pp.next);
                //System.out.println("(val: "+ pp.val + ", count:"+ pp.count + ")");
                if( pp.val == nums[i]){
                    mark = true;
                    pp.count++;
                    break;
                }
                    
                pp = pp.next;
            }
            
            //System.out.println("mark: "+ mark + ",node val: "+pp.val + ",next: " + pp.next);
            
            if(mark == false && pp.val == nums[i]){
                //System.out.println("check last node (val: "+ pp.val + ", count:"+ pp.count + ")");
                mark = true;
                pp.count++;
            }
            
            if( mark == false && pp.val != nums[i]){
                //System.out.println("create new node");
                Node temp = new Node(nums[i],1);
                pp.next = temp;
                pp = pp.next;
            }

        }
        
        int n = 0;
        int value = -1;
        
        pp = head;
        while( pp != null){
            //System.out.println("val: "+ pp.val + ", count: " + pp.count);
            if( pp.count > n){
                n = pp.count;
                value = pp.val;
            }
                
            pp = pp.next;    
        }
        
        if( n >= nums.length/2)
            result = value;
        
        return result;
    }
    private class Node {
        int val;
        int count;
        Node next;
        
        private Node(int val, int count) {
            this(val, count, null);
        }
        
        private Node(int val, int count, Node next) {
            this.val = val;
            this.count = count;
            this.next = next;
        }
    }    
}