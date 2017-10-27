/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        return helper(nestedList, nestedList.size(), 0, 1);
        
    }
    
    private int helper(List<NestedInteger> nestedList, int size, int idx, int layer){
        
        //System.out.println("nestedList: " + nestedList);
        //System.out.println("size: " + size + "idx: " + idx + "layer: " + layer);
        
        if( idx >= size)
            return 0;
        
        NestedInteger list = nestedList.get(idx);
        
        if( list.isInteger() == true){
            Integer val = layer * list.getInteger();
            idx++;
            return val + helper(nestedList, size, idx, layer);
        }
        
        List<NestedInteger> nextList = list.getList();
        
        layer++;
        
        int val = helper(nextList, nextList.size(),0, layer);
        
        if( idx < size){
            idx++;
            layer--;
            return val + helper(nestedList,size,idx, layer);    
        }
        return val;
        
        //return 0; //dummy code
    }
}