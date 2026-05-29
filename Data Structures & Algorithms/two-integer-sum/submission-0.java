class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++){
            int index = i + 1;
            while(index < nums.length){
                if(nums[i] + nums[index] != target){
                    index++;
                } else {
                    res[0] = i;
                    res[1] = index;
                    break;
                }
            }
        }



        return res;
    }
}
