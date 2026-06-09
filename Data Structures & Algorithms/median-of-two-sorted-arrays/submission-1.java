class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int till = ((n+m)/2)+1;
       
        int i=0, j=0;
        ArrayList<Integer>list = new ArrayList<>();
        while(till>0){
            if (i < n && (j >= m || nums1[i] <= nums2[j])) {
                list.add(nums1[i++]);
            }else {
                list.add(nums2[j]);
                j++;
            }
            till--;
        }
        int total = m+n;
        if(total %2 ==0){
            int el = list.get(list.size()-1);
            int ele = list.get(list.size()-2);
            return (el+ele)/2.0;
        }
        return list.get(list.size()-1);
    }
}
