class Solution {
    List<List<Integer>> superlist = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        boolean[] remainIndex = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) remainIndex[i] = true;
        recur(new ArrayList<>(), remainIndex);
        return superlist;
    }
    private void recur(List<Integer> list, boolean[] remainIndex){
        if(list.size() == nums.length){
            superlist.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < remainIndex.length; i++){
            if(remainIndex[i]){
                list.add(nums[i]);
                remainIndex[i] = false;
                recur(list, remainIndex);
                remainIndex[i] = true;
                list.remove(list.size() - 1);
            }
        }
    }
}
