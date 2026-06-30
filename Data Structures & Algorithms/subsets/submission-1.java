class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current  = new ArrayList<>();

        construct(result, new ArrayList<>(), nums, 0);
        return result;


        
    }
    public void construct(List<List<Integer>> result, List<Integer> current, int[] nums, int index)   {
        //as first step, add empty array to the result
        result.add(new ArrayList<>(current));

        //now loop through items, start with index
        for(int i=index; i<nums.length; i++ ) {
            //add to current
            current.add(nums[i]);
            //move forward to the next element
            construct(result, current, nums, i+1);

            //now move back one element to execute NO path
            current.remove(current.size() - 1);

        }

    }
}
