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
    
    public List<Integer> rightSideView(TreeNode root) {
         
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if( root == null)
            return list;
        
        TreeNode p = root;
        list.add(root.val);
        
        while(p != null){
            if( p.right != null && p.right.left == null && p.right.right == null){
                list.add(p.right.val);
                p = p.left;
            }
            else if(p.right != null){
                list.add(p.right.val);
                p = p.right;
            }
            else if(p.right == null && p.left != null){
                list.add(p.left.val);
                p = p.left;
            }else{
                p = null;
            }              
        }
        
        return list;
    }   
}