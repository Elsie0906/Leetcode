import java.util.ArrayList;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums1.length; i++){  // O(n1)
            set.add(nums1[i]);
        }
        
        if( set.size() == 0)
            return nums1;
        
        HashSet<Integer> hs = new HashSet<>();
        for(int j=0; j<nums2.length; j++){      // O(n2)
            if( set.contains(nums2[j])){    // repeat
                hs.add(nums2[j]);
            }
        }
        
        int[] arr = new int[hs.size()];
        int idx=0;

        Iterator iterator = hs.iterator();
        
        while (iterator.hasNext()) {
            arr[idx++] = (int)iterator.next();  
        }
        
        return arr;
    }
}