/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    
    public void connect(TreeLinkNode root) {
        
        helper(root);
        
    }

    private void helper(TreeLinkNode p){

        if( p == null)
            return;

        TreeLinkNode l = p.left;
        TreeLinkNode r = p.right;

        if( l != null){                             // check 1
            l.next = r;
        }
        
        if( p.next != null && p.right != null){     // check 2
            p.right.next = p.next.left;
        }
        
        helper(p.left);
        helper(p.right);

    }

}