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
    ArrayList<Integer> Leftlist = new ArrayList<Integer>();
    ArrayList<Integer> Rightlist = new ArrayList<Integer>();
    
    public void LeftRight(TreeNode node){
        
        //System.out.println("left to right node: "+ node + ", value: " + node.val);
        
        Leftlist.add(node.val);
        
        if( node.left != null ){
            LeftRight( node.left );
        }else if( node.left == null && node.right!=null)
        {
            //System.out.println("left to right check: 9999");
            Leftlist.add(9999);
        }
        
        if( node.right != null ){
            LeftRight( node.right );
        }else if( node.right == null && node.left != null )
        {
            //System.out.println("left to right check: 9999");
            Leftlist.add(9999);
        }
        
    }
    public void RightLeft(TreeNode start){
        
        //System.out.println("right to left node: "+ start + ", value: " + start.val);
        
        Rightlist.add(start.val);

        if( start.right != null ){
            RightLeft( start.right );
        }else if(start.right == null && start.left!= null )
        {
            //System.out.println("right to left check: 9999");
            Rightlist.add(9999);
        }         
        
        if( start.left != null ){
            RightLeft( start.left );
        }else if( start.left == null && start.right != null)
        {
            //System.out.println("right to left check: 9999");
            Rightlist.add(9999);
        }       
    }
    public boolean isSymmetric(TreeNode root) {
        boolean result = true;
        
        if( root == null )
            return result;
        
        // if(leftRight == rightLeft) isSymmetric
        
        LeftRight(root);
        RightLeft(root);
        
        if( Leftlist.size() != Rightlist.size())
            return false;        
        
        for( int i=0; i<Leftlist.size(); i++){
            
             //System.out.println("left Number = " + Leftlist.get(i));
             //System.out.println("Right Number = " + Rightlist.get(i));
            
             int left = Leftlist.get(i);
             int right = Rightlist.get(i);
          
             if(left != right){
                return false; 
             }else{
                result = true; 
             }
             
        }
        
        return result;
    }
}