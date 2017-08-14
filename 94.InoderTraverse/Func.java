/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * In-order traverse: left -> root -> right
**/
public class Solution {
    List<Integer> aList = new LinkedList();
    public List<Integer> inorderTraversal(TreeNode root) {            
        if( root == null)
            return aList;
        
        if( root.left != null)
            inorderTraversal(root.left);
        
        aList.add(root.val);
        
        if( root.right != null)
            inorderTraversal(root.right);
        
        return aList;
    }
}