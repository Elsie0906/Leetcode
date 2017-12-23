/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if( head == null)                   // empty list
            return head;
        
        ListNode p = head;
        
        if( p != null && p.val == val){     // remove first node
            p = p.next;
            return removeElements(p, val);
        } 
                           
        
        while(p != null){                                  
            
            while( p.next != null && p.next.val == val){       // from second node, ex. [1,2,2,1] val = 2
                p.next = p.next.next;
            }   
            
            p = p.next;
        }
 
        
        return head;
    }
}