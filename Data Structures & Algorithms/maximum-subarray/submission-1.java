class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = nums.clone();

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i], dp[i] + dp[i-1]);
        }

        int res = dp[0];
        for(int n : dp){
            res = Math.max(res, n);
        }

        return res;
    }
}
