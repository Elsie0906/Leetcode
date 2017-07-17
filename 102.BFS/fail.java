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
    ArrayList<Integer> nodeList = new ArrayList<Integer>();
    ArrayList<Integer> levelList = new ArrayList<Integer>();

    public void foo(int height, TreeNode Root, List<List<Integer>> allRows, ArrayList<Integer> Row){
        
        if(Root == null) return;
        
        //ArrayList<Integer> Row = new ArrayList<Integer>();
        Row.add(Root.val);
        allRows.add(height, Row);
        Row = new ArrayList<Integer>();
        
        nodeList.add(Root.val);
        levelList.add(height);
        
        //System.out.println("current node: "+ Root + ", value: " + Root.val + ", height: " + height);
        
        foo(height+1, Root.left, allRows, Row);
        foo(height+1, Root.right, allRows, Row);
    }
    public List<List<Integer>> levelOrder(TreeNode root)  {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();        
        
        if( root == null )
            return allrows;
        
        ArrayList<Integer> row = new ArrayList<Integer>();
        
        foo(0,root, allrows, row);
        
        // display the array list
        System.out.println("Contents of nodeList: " + nodeList);   
        System.out.println("Contents of levelList: " + levelList);

/*
        int preRow = 0;
        int numRows = 0;
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0; i<nodeList.size(); i++){
            numRows = levelList.get(i);
            //System.out.println("numRows: " + numRows + "preRow" + preRow);
            if(numRows == preRow){
                row.add(nodeList.get(i));
            }
            while(numRows != preRow){
                allrows.add(preRow, row);
                preRow = numRows;
                row = new ArrayList<Integer>();
                row.add(nodeList.get(i));
            }     
            
            if(i == (nodeList.size() - 1))
               allrows.add(preRow, row); 
        }
*/        
        
        return allrows;
    }
}