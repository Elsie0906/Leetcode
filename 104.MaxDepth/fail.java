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
        int count;
        
        public void Initiate( int value){
            count = value;
        }
        
        public void leftTraverse( TreeNode node){
            
            if( node.left != null)
            {
                count++;
                leftTraverse( node.left);
            }    
        }
        
        public void rightTraverse( TreeNode Node){
            
            if( Node.right != null){
                count++;
                rightTraverse( Node.right );
            }
        }
        
        public void traverse( TreeNode Root){
            
            System.out.println("Root value: " +  Root.val); 
            
            // when a root doesn't have left and right child, don't count
            
            if( Root.left == null && Root.right != null)
                count++;
            else if( Root.right == null && Root.left != null )
                count++;
            
            if( Root.left != null)
            {
                count++;
                traverse( Root.left);
            }
            
            if( Root.right != null)
            {
                count++;
                traverse( Root.right );
            }
        }
        
        public int Calculate( int x ){
            int Value = 2;
            int power = 1;
            
            if( x == 1 || x == 2 )
                return 2;
            
            do{
                power++;
                Value = (int)Math.pow(2, power);
                //System.out.println("pow: " + power + ", Value: " + Value + ", x: " + x); 
            }while( Value < x);
            
            if(Value == x)
                power++;
                
            return power;
        }
    }
    
    public int maxDepth(TreeNode root) {
        int result = 0;
        MyClass myC = new MyClass();
        int layer = 0;
        
        if( root == null ) return 0;
        
        
 
/* weaken: only counting valid value, total count = 5, when input: [-8, -6, 7, 6, null, null, null, null,5] */

        myC.Initiate(1);
        myC.traverse( root );
        
        System.out.println("total count: " + myC.count);
        
        layer = myC.Calculate(myC.count);
        System.out.println("calculate: " + layer);
        
        result = layer;
       
 
/*        
        // Random checking //
        // Weaken: non-balance binary tree //
       
        // left 
        myC.Initiate(1);
        myC.leftTraverse( root );
        
        System.out.println("left count: " + myC.count); 
        
        result = myC.count;       
        
        // right
        myC.Initiate(1);
        myC.rightTraverse( root );
        
        System.out.println("right count: " + myC.count);        
      
        if( myC.count > result )
            result = myC.count;
*/
        
        return result;
    }
}