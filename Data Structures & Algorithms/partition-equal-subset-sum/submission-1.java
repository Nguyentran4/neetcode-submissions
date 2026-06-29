class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum % 2 != 0) return false;

        int target =  totalSum / 2;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];;
            }
        }



        return dp[target];
    } //Turn Partition into Target = Sum/2,
    //then do 0/1 Knapsack backward so each number is used once.


}
