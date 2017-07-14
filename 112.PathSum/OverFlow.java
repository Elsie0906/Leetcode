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
    Stack<TreeNode> stack = new Stack<TreeNode>();
    Stack<TreeNode> valS = new Stack<TreeNode>();    
    int tempCal = 0;
    //int visitCount = 0;
    boolean check = false;
    //int maxStacksize = 0;
    //int maxValSsize = 0;
    public void checkFirst(TreeNode Node){
        if( Node.left != null && Node.right != null){
            //System.out.println("two choices: " + Node);
            stack.push(Node);
        } 
        
    }     
    public void traverseAndCheck(TreeNode node, int target){
        //visitCount++;
        //maxStacksize = Math.max(maxStacksize, stack.size());
        //maxValSsize = Math.max(maxValSsize, valS.size());
        
        checkFirst(node);
        
        valS.push(node);
        
        tempCal = tempCal + node.val;
        System.out.println("current node: "+ node + "node value: "+ node.val + ", temp calculate: " + tempCal);
        
        if((tempCal == target) && (node.left == null) && (node.right == null)){
            System.out.println("Find the path!! ");
            check = true;
            return;
        }
        
        if((tempCal != target) && (node.left == null) && (node.right == null)){
            System.out.println("Oh Oh!! Need to try another path ");
            check = false;

            if(stack.empty() == true){
                System.out.println("Stack is empty now!!");
                return;
            }
            else{
          
                // try another way            
            
                TreeNode tempNode = stack.pop();
                System.out.println("Find another way out!! " + tempNode);   
                
                // recalculate
                TreeNode reCal = valS.pop();
                tempCal = tempCal - reCal.val;
                //System.out.println("back to node: " + reCal + ", tempCal: " + tempCal);                
                
                while(reCal != tempNode){
                    reCal = valS.pop();
                    if( reCal == tempNode){
                        valS.push(reCal);
                        System.out.println("back to node: " + reCal + ", tempCal: " + tempCal);                          
                    }   
                    else{
                        tempCal = tempCal - reCal.val;
                        //System.out.println("back to node: " + reCal + ", tempCal: " + tempCal);                         
                    }
                }
                
                if(tempNode.left != null && tempNode.right != null){
                    traverseAndCheck(tempNode.right, target);      
                }
                else if(tempNode.left != null && tempNode.right == null){
                    traverseAndCheck(tempNode.left, target);
                }   
                else if(tempNode.left == null && tempNode.right != null){
                    traverseAndCheck(tempNode.right, target);
                }
                else{
                    return;
                }
            }
        }
        
        if(node.left != null && node.right != null){
            traverseAndCheck(node.left, target);
        }
        else if(node.left == null && node.right != null){
            traverseAndCheck(node.right, target);
        }
        else if(node.left != null && node.right == null){
            traverseAndCheck(node.left, target);
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result = false;
        
        if( root == null )
            return false;
        
        //System.out.println("root: "+ root + ", target: " + sum);
        
        traverseAndCheck(root, sum);
        
        //System.out.println("check result: "+ check);
        System.out.println("Is stack empty now: " + stack.empty());
        
        while(stack.empty() == false){
            stack.pop();
        }
        
        while(valS.empty() == false){
            valS.pop();
        }
        
        result = check;
        
        //System.out.println("visitCount:" + visitCount);
        //System.out.println("maxStacksize:" + maxStacksize);
        //System.out.println("maxValssize:" + maxValSsize);
            
        return result;
    }
}