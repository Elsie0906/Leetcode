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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        final HashMap newmap = new HashMap(); // (key, value)
        
        queue.offer(root);
        newmap.put(root.val, root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            
            System.out.println("node: " + node.val);

            if(node.left != null) {
                queue.offer(node.left);
                newmap.put(node.left.val, node);
            }
            if(node.right != null) {
                queue.offer(node.right);
                newmap.put(node.right.val, node);
            }
        }
        
        TreeNode reVal1 = (TreeNode)newmap.get(p.val);
        TreeNode reVal2 = (TreeNode)newmap.get(q.val);
        
        System.out.println("root1: " + reVal1.val + ", root2: " + reVal2.val);
        
        System.out.println("Map value after change: "+ newmap);
        
        return root;
    }
}