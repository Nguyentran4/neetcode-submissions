class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsUnique = new HashSet<>();

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            numsUnique.add(nums[i]);
        }

        for(Integer numSet : numsUnique) {
            if (!numsUnique.contains(numSet-1)) {
                int maxCurrent = 1;
                while(numsUnique.contains(numSet+1)) {
                    maxCurrent++;
                    numSet++;
                }
                if (max < maxCurrent) max = maxCurrent;
            }
        }

        return max;

    }
}