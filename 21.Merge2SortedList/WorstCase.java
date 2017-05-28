/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * ex. ListNode temp = new ListNode(1);
 */
 
import java.util.*;  

 
public class Solution {

    public class insertion{
        public void sort(int[] a)
        {
            int N = a.length;
        
            for(int i=0; i<N; i++)
                for(int j=i; j>0; j--)
                    if(less(a[j],a[j-1]))
                        exchange(a, j, j-1);
                    else
                        break;        
        }
    
        private boolean less(int v, int w)
        {
            return v<w;
        }
    
        private void exchange(int[] a, int i, int j)
        {
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        insertion insertS = new insertion();
        int count = 0;
        ListNode temp;
        ListNode result,oldresult;
        
        /* a new array by concatenating l1 & l2*/
        
        temp = l1;
        
        while(temp != null)
        {
            //System.out.println("original content of node l1: " + temp.val);
            //System.out.println("node l1: " + temp);
            count++;
            temp = temp.next;
        }
        
        temp = l2;
        
        while(temp != null)
        {
            count ++;
            temp = temp.next;
        }   
        
        int[] ll = new int[count];
 
        temp = l1;
        count = 0;
        
        while(temp != null)
        {
            ll[count] = temp.val;
            count++;
            temp = temp.next;
        }
        
        temp = l2;
        
        while(temp != null)
        {
            ll[count] = temp.val;
            count ++;
            temp = temp.next;
        }       
        
        // Print all the array elements
        
        System.out.println("original content of ll: ");
        
        for (int i = 0; i < ll.length; i++) {
             System.out.println(ll[i]);
        }
        
        /* insertion sort*/
        
        insertS.sort(ll);

        System.out.println("modified content of ll: ");
        
        result = null;
        
        /* in a form of linked list node*/
        
        for (int i = ll.length; i >0; i--) {
             ListNode tempNode = new ListNode(ll[i-1]);
             tempNode.next = result;
             result = tempNode;
             System.out.println(ll[i-1]);
        }
        
        return result;
    }
}