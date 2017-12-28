/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        
        if( root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        traverse(q);        // BFS
        
        return -1;    // dummy
    }
    
    private void traverse(Queue<TreeNode> q){
        
        TreeNode root = q.remove();
        
        if( root == null)
            return;
        
        System.out.println("val: " + root.val);
        
        q.add(root.left);
        q.add(root.right);
            
        traverse(q);    
    }
}