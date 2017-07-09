/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*  Method:
    1. find the middle one, ex. [1,2,3] -> mid = 2; [1,2] -> mid = 1
    2. split the original array into 2 sub-array ex. [1,2] [4,5]
    3. back to step 1 until no item left
*/
/*
    It is a balanced binary tree, but not a binary search tree
    Balances tree:
    1. The left and right subtrees' heights differ by at most one, AND
    2. The left subtree is balanced, AND
    3. The right subtree is balanced
    
    Binary search tree: left < root && right > root for binary search
    
        2
      /   \
    1       3
*/
public class Solution {    
    public void Construct(int[] Array, int startIdx, int midIdx, int endIdx, TreeNode Root){
        
        // left: startIdx ~ midIdx
        // right: midIdx ~ endIdx
        
        int left = midIdx - startIdx;
        int right = endIdx - midIdx;
        
        //System.out.println("start: "+ startIdx + ", mid: " + midIdx + ", end: " + endIdx);
        
        if( left > 0){
            int middle = FindMid(startIdx, midIdx-1);
            //System.out.println("start from left "+ middle);
            TreeNode node = new TreeNode(Array[middle]);
            Root.left = node;
            Construct(Array, startIdx, middle, midIdx-1, node);            
        }
     
        if( right > 0){
            int middle = FindMid(midIdx+1, endIdx);
            //System.out.println("start from right "+ middle);
            TreeNode node = new TreeNode(Array[middle]);
            Root.right = node; 
            Construct(Array, midIdx+1, middle, endIdx, node);
        }    
        
    }
    public int FindMid(int startIndex, int endIndex){
        int middle = 0;
        int len = endIndex - startIndex + 1;
        
        if( (len%2) == 1)
            middle = (startIndex+endIndex)/2;
        else
            middle = (startIndex+endIndex-1)/2;        
        
        return middle;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        TreeNode newNode = null;
        TreeNode startNode = null;
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        
        if( nums.length == 0 )
            return startNode;
        
        // start: 0~N-1
        
        mid = FindMid(start, end);
        root = new TreeNode(nums[mid]);        
        startNode = root;
        
        Construct(nums, start, mid, end, root);
        
        return startNode;
    }
}