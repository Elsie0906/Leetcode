/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int overflow = 0;
    public int retrieve(ListNode ll){
        int number = 0;
        
        if( ll != null )
            number = ll.val;
        
        return number;            
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // n1>0 && n2>0
        
        ListNode node = new ListNode(0);
        ListNode start = node;       
        //int n1, n2;
        int n1 = 0;
        int n2 = 0;
        int temp = 0;
        
        while((l1 != null) || (l2 != null) || (overflow>0)){

            n1 = retrieve(l1);
            n2 = retrieve(l2);

            temp = n1 + n2 + overflow;
            
            //System.out.println("n1: "+ n1 + ", n2: " + n2 + ", overflow: " + overflow);
            
            // check if it overflow        
            
            overflow = temp/10;
            node.val = temp%10;
            //System.out.println("rem: "+ node.val + ", overflow: " + overflow);
            
            if( l1 == null && l2 == null && overflow == 0)
                break;
            
            if((l1 != null && l1.next != null) || (l2 != null && l2.next!= null) || (overflow > 0)){
                node.next = new ListNode(0);
                node = node.next;                 
            }
            
            if( l1 != null)
                l1 = l1.next;
            
            if( l2 != null)
                l2 = l2.next;
            
        }
        
        return start;
    }
}