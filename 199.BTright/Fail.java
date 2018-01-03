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
    
    private Queue<TreeNode> queue = new LinkedList<TreeNode>();
    private ArrayList<TreeNode> arrlist = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
         
        if( root == null)
            return new ArrayList<Integer>();
        
        helper(root);
        
        printOut();
        
        List<Integer> list = pick();
        
        return list;
    }
    private void helper(TreeNode root){
        
        queue.add(root);
        arrlist.add(root);
        
        while(!queue.isEmpty()){
            TreeNode p = queue.remove();
            
            if( p == null)
                continue;
            
            arrlist.add(p.left);
            arrlist.add(p.right);
            if( p.left != null || p.right != null){
                queue.add(p.left);
                queue.add(p.right);                
            }
        }
    }
    private List<Integer> pick(){
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<arrlist.size(); i=(i+1)*2){
            if( arrlist.get(i) != null){
                list.add(arrlist.get(i).val);
            }
            else{
                TreeNode temp = arrlist.get(i);
                int idx = i/2 -1;
                //System.out.println("[Debug] i: " + i + ", idx: " + idx);
                while(temp == null && i > idx){
                    //System.out.println("[Debug] i: " + i);
                    i--;
                    temp = arrlist.get(i);
                }
                
                if( i == idx)
                    break;
                
                if( arrlist.get(i) != null)
                    list.add(arrlist.get(i).val);
            }
            
        }
        
        return list;
    }
    private void printOut(){
        
        for(int i=0; i<arrlist.size(); i++){
            if( arrlist.get(i) != null)
                System.out.println("val: " + arrlist.get(i).val);
            else
                System.out.println("val: " + arrlist.get(i));
        }
    }
}