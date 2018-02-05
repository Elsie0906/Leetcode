/*
* [1,2][2,1]
* output: [2]
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // brute force
        
        int strIdx1 = 0, strIdx2 = 0;
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if( nums1[i] == nums2[j]){
                    // might be an intersection
                    //if( i<nums1.length-1 && j<nums2.length-1 && nums1[i+1] == nums2[j+1])
                    {
                        strIdx1 = i;
                        strIdx2 = j;
                        break;
                    }    
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(strIdx1<nums1.length && strIdx2<nums2.length){
            if(nums1[strIdx1] == nums2[strIdx2]){
                list.add(nums1[strIdx1]);
                strIdx1++;
                strIdx2++;                
            }
            else{
                break;
            }
        }
        
        int[] arr = new int[list.size()];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            arr[idx] = list.get(i);
            idx++;
        }
        
        return arr;
    }
}