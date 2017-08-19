/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode pp = new ListNode(-1); 
        ListNode pp_next = new ListNode(-1);
        ListNode cur = head;
        
        if( head == null)
            return head;
        
        while(head != null){
            pp_next = head.next;         // next node
            cur = head;                  // current node
           
            if( pp.val != -1){
                head.next = pp;  // change direction
                while(  head.next != null && head.val>head.next.val){
                        int temp = head.next.val;  // switch, overwrite
                        head.next.val = head.val;
                        head.val = temp;   
                        head = head.next;
                }
            }
                 
            if( pp.val == -1){
                pp = cur;
                pp.next = null;                
            }
            
            pp = cur;
            head = pp_next;
        }
        
        
        return pp;
    }
}