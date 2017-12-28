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
        
        int num = traverse(root);        // BFS
        
        return num;    // dummy
    }
    
    private int traverse(TreeNode root){
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        TreeNode p;
        int count = 0;
        
        while(!q.isEmpty()){
            
            p = q.remove();
            count++;
            
            if( p.left != null)
                q.add(p.left);
            
            if( p.right != null)
                q.add(p.right);
        }
          
        return count;
    }
}