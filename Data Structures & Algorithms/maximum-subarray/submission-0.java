class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = nums.clone();

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i], nums[i] + dp[i - 1]);
        }

        int maxNum = dp[0];

        for(int n : dp){
            maxNum = Math.max(maxNum, n);
        }

        return maxNum;
    }
}
