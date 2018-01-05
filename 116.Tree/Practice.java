/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Practice {
    private ArrayList<TreeLinkNode> alist = new ArrayList<>();
    
    public void connect(TreeLinkNode root) {
        
        TreeLinkNode p = root;
        
        if( p == null)
            return;
        
        alist.add(p);
        
        int idx = 0;
        
        do{
            if( p.left != null)
                alist.add(p.left);
            if( p.right != null)
                alist.add(p.right);
            
            if( idx < alist.size()-1)
                p = alist.get(++idx);
            else
                break;
            
        }while( p != null  || idx < alist.size());
        
        printOut();

        int count = 1, index = 0;

        for(int i=0; i<alist.size(); i++){
            if( i == index){
                alist.get(i).next = null;
                count *= 2;
                index += count;
            }
            else{
                alist.get(i).next = alist.get(i+1);
            }
        }
    }

    private void printOut(){

        System.out.println();
        for(int i=0;  i<alist.size(); i++){
            System.out.print(alist.get(i).val + " ");
        }
        System.out.println();
    }
}