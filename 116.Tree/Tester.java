import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

class Tester {
    public static void main(String[] args) {
            int[] nums = {1,2,3,4,5,6,7};

            // create tree
            TreeLinkNode root = new TreeLinkNode(1);

            Queue<TreeLinkNode> q = new LinkedList<>();

            q.add(root);

            for(int i=1; i<nums.length; i=i+2){

            	TreeLinkNode l = new TreeLinkNode(nums[i]);
            	TreeLinkNode r = new TreeLinkNode(nums[i+1]);

            	q.add(l);
            	q.add(r);

            	TreeLinkNode p = q.remove();
            	p.left = l;
            	p.right = r;
            }

            Practice pra = new Practice();

            pra.connect(root); 

    }
}