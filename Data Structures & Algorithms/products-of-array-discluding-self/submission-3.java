class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];


        res[0] = 1;

        // Build prefix products
        // res[i] = product of all elements before i (left multiplication)
        for(int i = 1; i < n; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int postfix = 1;
        for(int i = n - 1; i >= 0; i--){ //(product of right side)
            res[i] *= postfix;
            postfix *= nums[i];
        }


        return res;
    }
}  
