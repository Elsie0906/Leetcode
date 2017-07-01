/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class MyClass{
        boolean compare = true;
        
        // left -> right
        public boolean check( TreeNode root1, TreeNode root2){
        
            if(root1 == null && root2 == null)
            {
                //System.out.println("Both ends ");
                compare = true;
                return compare;
            }
            
            if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            {
                //System.out.println("tree number are not equal 3 ");
                compare = false;
                return compare;
            }    
            
            if( (root1 != null && root2 != null))
            {
                //System.out.println("node1 value: " + root1.val + ", node2 value: " + root2.val);
                if( root1.val != root2.val )
                {
                    compare = false;
                    return compare;
                }
            }
        
            if((root1.left == null && root2.left!= null) ||(root1.left != null && root2.left == null))
            {
                //System.out.println("tree number are not equal 1 ");
                compare = false;
                return compare;
            }   
        
            if( root1.left != null && root2.left != null)
                check(root1.left, root2.left);
 
            if((root1.right == null && root2.right!= null) ||(root1.right != null && root2.right == null))
            {
                //System.out.println("tree number are not equal 2 "); 
                compare = false;
                return compare;
            }
            
            if( root1.right != null && root2.right != null)
                check(root1.right, root2.right);
        
            return compare;
        }        
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = false;
        MyClass myC = new MyClass();
               
        result = myC.check(p,q);
        
        return result;
    }
}