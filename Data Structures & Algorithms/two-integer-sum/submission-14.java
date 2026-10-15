class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++){
            int required = target - nums[i];
            if(map.containsKey(required)){
                return new int[]{map.get(required), i};
            }
            map.put(nums[i], i);
        }

        return new int[-1];
    }
}

// Time complexity: O(n), where n is the length of the input array. Each element is processed once, with O(1) average-time map operations.
// Space complexity: O(n) in the worst case, since the hash map may store up to n distinct numbers.