/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode find = null;
        ListNode point = headA;
        HashMap newmap = new HashMap();
        
        while( point != null ){
            newmap.put(point, point.val);
            point = point.next;
        }
        
        point = headB;
        
        while( point != null ){

            // Hashmap: (key,value), check existance of duplicated key
            if( newmap.containsKey(point)){
                //System.out.println("Intersection found!!"); 
                find = point;
                break;
            }
            else
                newmap.put(point, point.val);
            
            point = point.next;
        }
        
        return find;
    }
}