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
    
    private ArrayList<TreeNode> arr = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if( root == null)
            return list;
        
        int h = findHeight(root);
        
        //System.out.println("height: " + h);
        
        return list;
    }
    
    private int findHeight(TreeNode root){
        
        if( root.left != null){
            return findHeight(root.left) + 1;
        }
        else if(root.right != null){
            return findHeight(root.right) + 1;
        }
        else
            return 1;
    }
}