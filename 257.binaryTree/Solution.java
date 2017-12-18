/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> list = new LinkedList<String>();  
        
        if( root == null)
            return list;
        
        String s = "";
        list = helper(root, list, s);
        
        return list;
    }
    
    private List<String> helper(TreeNode head, List<String> arrlist, String str){
        
        if( head != null && head.left == null && head.right == null)    // leaf
        {
            String s = new String(str) + head.val;
            arrlist.add(s);
            return arrlist;
        }    
              
        String s = new String(str) + head.val + "->";
        
        if( head.left != null){
            arrlist = helper(head.left, arrlist, s);
        }
        
        if( head.right != null){
            arrlist = helper(head.right, arrlist, s);
        }
        
        return arrlist;
    }  
}