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
        
        traverse(root);        // BFS
        
        return -1;    // dummy
    }
    
    private void traverse(TreeNode root){
        
        ArrayList<Integer> q = new ArrayList<>();
        
        boolean val = false;
        
        TreeNode p = root;
        
        val = isEqual(p);
        
        if( val == true){           // complete & full binary tree
            
            int layer = 0;
            
            while(p != null){
                layer++;
                p = p.left;
            }
            
            int num = (int)Math.pow(2,layer) - 1;
            
            //System.out.println("num: " + num);
        }
            
       
        while(p != null){
            
            val = isEqual(p.right);
            
            if( val == false){          // check either left subtree or right subtree
                p = p.right;
                q.add(2);
            }
            else{
                p = p.left;
                q.add(1);
            }         
        }
        
        System.out.println("q: " + q);
        
        
    }
    
    private boolean isEqual(TreeNode root){
        
        TreeNode l = root;
        int countL = 0;
        
        while(l != null){
            countL++;
            l = l.left;
        }
        
        TreeNode r = root;
        int countR = 0;
        
        while(r != null){
            countR++;
            r = r.right;
        }
        
        return (countL == countR);
    }
}