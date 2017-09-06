/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if( head == null)
            return head;
        
        ListNode pp = head;
        ListNode pre = null;
        ListNode nextP = null;
        
        while(pp != null){
            nextP = pp.next;
            pp.next = pre;
            pre = pp;                
            pp = nextP;
        }
        
        return pre;
    }
}