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
    
    private ArrayList<TreeNode> node = new ArrayList<>();
    private ArrayList<Integer> layer = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        
        if( root == null)
            return new ArrayList<Integer>();

        node.add(root);
        layer.add(0);
        
        helper(0);
        
        //printOut();
        
        return pick();
    }   
    
    private List<Integer> pick(){
        
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> reverse = new ArrayList<Integer>();
        
        int cur = -1;
           
        for(int i=node.size()-1; i>=0; i--){
            //System.out.print(i + " ");
            if( layer.get(i) != cur){
                reverse.add(node.get(i).val);
                cur = layer.get(i);
            }            
        }
        
        for(int i=reverse.size()-1; i>=0; i--){
            list.add(reverse.get(i));
        }
        
        return list;
    }
    
    private void helper(int idx){
        
        if( idx >= node.size())
            return;
        
        TreeNode p = node.get(idx);
        
        if( p == null)
            return;
        
        int l = layer.get(idx)+1;
        
        if( p.left != null){
            node.add(p.left);
            layer.add(l);
        }
        
        if( p.right != null){
            node.add(p.right);
            layer.add(l);
        }
        
        helper(++idx);
    }
    
    private void printOut(){
        
        for(int i=0; i<node.size(); i++){
            if( node.get(i) != null)
                System.out.println("val: " + node.get(i).val + ", layer: " + layer.get(i));
            else
                System.out.println("val: " + node.get(i));
        }
    }
}