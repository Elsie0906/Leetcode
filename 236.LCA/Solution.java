/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Strategy:
// step1: traverse all the nodes and record its corresponding parent node
// stpe2: using a map/set, when a node is not allowed to insert -> we find the LCA
import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pp = root;
        HashMap<TreeNode,TreeNode> hm = new HashMap<>();
        hm.put(pp, null);  // root
        traverseTree(pp, hm);
        
        // test
        /*
        System.out.println("test: " + hm.get(pp));
        TreeNode temp = hm.get(pp.right.right);
        System.out.println("test: " + pp.right.right.val + ", parent: " + temp.val);
        */

        HashSet<TreeNode> hs = new HashSet<>();

        TreeNode child = p;
        TreeNode parent = hm.get(child);
        hs.add(child);

        while(parent != null){
            boolean val = hs.add(parent);
            if( val == false){
                System.out.println("should not happen!!");
                return parent;
            }

            child = parent;
            parent = hm.get(child);
        }

        child = q;
        parent = hm.get(q);

        boolean reval = hs.add(child);
        if( reval == false)
            return child;

        while(parent != null){
            boolean val = hs.add(parent);
            if( val == false)
                return parent;

            child = parent;
            parent = hm.get(child);
        }       


        return root;

    }
    
    private void traverseTree(TreeNode pp, HashMap<TreeNode,TreeNode> hm){
        
        if( pp == null)
            return ;
        
        // record its corresponding parent node
        
        if( pp.left != null){
            hm.put(pp.left, pp);
        }
            
        if( pp.right != null){
            hm.put(pp.right, pp);
        }
        
        traverseTree(pp.left, hm);
        traverseTree(pp.right, hm);
    }
}