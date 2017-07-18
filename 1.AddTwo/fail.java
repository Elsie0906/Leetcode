/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int calNum(ListNode ll){
        int number = 0;
        int pow = 0;
        int count = 0;
        
        /* WARNING: java max integer 2147483647 */
        
        while(ll != null){
            pow = (int) Math.pow(10,count);
            number = number+ll.val*pow;
            System.out.println("check 1: "+ ll.val + ", pow: " + pow + ", num: " + number);    
            count++;
            ll = ll.next;
        }
        
        System.out.println("num: "+ number);
        
        return number;
    }
    public ListNode reverseNum(int N){
        int pow = 10;
        int count = 1;
        ListNode newNode = new ListNode(0);
        ListNode start = newNode;
        
        //System.out.println("start node: "+ start); 
        
        while(N > 0)
        {
            newNode.val = N % pow;
            N = N/pow;
            System.out.println("check 2: "+ newNode.val + " and " + N );
            if( N > 0){
                newNode.next = new ListNode(0);
                newNode = newNode.next;                
            }
        }
        return start;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // n1>0 && n2>0
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int n1 = calNum(l1);
        int n2 = calNum(l2);
        
        int n = n1+n2;
        
        ListNode L = reverseNum(n);
        
        return L;
    }
}