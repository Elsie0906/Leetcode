/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode head1, head2;
    
    public boolean isPalindrome(ListNode head) {

        if( head == null)
            return true;
        
        findMid(head);
        
        System.out.print("head1: " + head1.val + ", head2: " + head2.val);
        
        // backtrace
        ListNode temp;
        ListNode pre = head;
        ListNode pp = head.next;
        
        //traverse(head);
        
        while(pp != null)
        {
            //System.out.println("pre: " + pre + ", current: " + pp + ", next: " + pp.next);
            pre.next = null;
            temp = pp.next;
            pp.next = pre;
            pre = pp;
            if( pp == head1)
                break;
            pp = temp;
        }
        
        traverse(head1);
        traverse(head2);
        
        // comparison
        
        boolean result = true;
        while(head1 != null && head2 != null){
            if( head1.val != head2.val)
                return false;
            
            head1 = head1.next;
            head2 = head2.next;
        }
     
        return result;
    }
    private void traverse(ListNode ll){
        System.out.println("traverse");
        while(ll != null){
            System.out.print(ll.val + " ");
            ll = ll.next;
        }
        System.out.println();
    }
    private void findMid(ListNode head){
        
        ListNode p1,p2,pre;
        
        pre = p1 = p2 = head;
        
        while(p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        //System.out.println("mid: " + p1 + ", even or odd: " + p2);
        /* 
        ** p2 != null -> odd sequence, p2 == null -> even sequence
        */
        
        if( p2 == null){
            head2 = p1;
            head1 = pre;
        }
        else{
            head1 = pre;  
            head2 = p1.next;
        }
            
        
    }
}