/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class MyClass{
        ListNode lastNode;
        ListNode preNode;
        
        public void Initiate(){
            lastNode = null;
            preNode = null;
        }
        
        public void FindLast(ListNode startNode){
            
            //System.out.println("node: "+ startNode + ", value: " + startNode.val);
        
            if( startNode.next != null ){
                preNode = startNode;
                FindLast( startNode.next );
            }else{
                lastNode = startNode;    
            }
        }
    }   
    public void traverse(ListNode node){
        
        System.out.println("traverse node: "+ node + ", value: " + node.val);
        
        if( node.next != null){
            traverse(node.next);
        }
    }
    
    public void reorderList(ListNode head) {
        
        if( head == null || head.next == null || head.next.next == null )
            return;
        
        MyClass myC = new MyClass();
        
        myC.Initiate();
        
        if( head != null)
            myC.FindLast(head);
        
        //if( head.next != null )
        //    System.out.println("next node: " + head.next + ", last node: " +  myC.lastNode);
        
        // change order
        
        while(head.next != myC.lastNode){
            myC.preNode.next = null;
        
            ListNode temp = head.next;
            head.next = myC.lastNode;
            myC.lastNode.next = temp; 
        
            //traverse(head);
            
            if( temp.next != null )
                reorderList( temp );
        }
        
    }
}