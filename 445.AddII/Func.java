/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode num = l1;
        
        l1 = reverseNum(l1);
        l2 = reverseNum(l2);
        
        //printOut(l1);
        //printOut(l2);
        
        num = addNum(l1,l2);
        //printOut(num);
        num = reverseNum(num);
        
        return num;     // dummy
    }
    private ListNode addNum(ListNode l1, ListNode l2){
        
        ListNode head = new ListNode(-1);
        ListNode ll = head;
        
        int extra = 0;
        
        while(l1 != null || l2 != null || extra !=0){
            
            //System.out.println("[debug] extra: " + extra);
            
            int value = -1;
            
            if( l1 != null && l2 != null){
                //System.out.print("l1: " + l1.val + ", l2: " + l2.val);
                value = (l1.val + l2.val + extra)%10;
                extra = (l1.val + l2.val + extra)/10;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 == null && l2 != null){
                //System.out.print("l2: " + l2.val);
                value = (l2.val + extra)%10;
                extra = (l2.val + extra)/10;
                l2 = l2.next;
            }else if(l2 == null && l1 != null){
                //System.out.print("l1: " + l1.val);
                value = (l1.val + extra)%10;
                extra = (l1.val + extra)/10;
                l1 = l1.next;
            }else if( extra == 1){
                value = extra;
                extra = 0;
            }
            
            //System.out.println(", value: " + value + ", extra: " + extra);
                
            ListNode temp = new ListNode(value);
            ll.next = temp;
            ll = ll.next;            
        }
        
        return head.next;
        
    }
    
    private void printOut(ListNode node){
        
        System.out.println("[check] num: ");
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    
    private ListNode reverseNum(ListNode ll){
        
        if( ll == null)
            return ll;
        
        ListNode cur = ll, nex = ll.next;
        
        cur.next = null;
        
        while(nex != null){
            ListNode temp = nex.next;
            nex.next = cur;
            cur = nex;
            nex = temp;
        }
        
        return cur;
        
    }
}