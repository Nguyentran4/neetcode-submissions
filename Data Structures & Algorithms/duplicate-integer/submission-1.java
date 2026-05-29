class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return false;
        Arrays.sort(nums);
        int num = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != num) {
                num = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
}