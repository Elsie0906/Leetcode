/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void traverse(ListNode node){
        
        while(node.next != null){
            System.out.println("Traverse::current node: "+ node + "value: " + node.val); 
            node = node.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode preNode = head;
        int value = -1, pre_value = -1;
        if( current == null)
            return head;
        
        //traverse(head);
        
        if( current != null)
            pre_value = value = current.val;
        
        while(current.next != null){
            //System.out.println("previous node: "+ current + "value: " + current.val); 
            current = current.next;
            value = current.val;
            //System.out.println("current node: "+ current + "value: " + current.val); 
            //System.out.println("pre node: "+ preNode + "pre_value: "+ pre_value + "value: " + value);
            if( pre_value == value){
                preNode.next = current.next;
            }
            else{
                preNode = current;
                pre_value = value;
            }
                
        }
        
        return head;
        
    }
}