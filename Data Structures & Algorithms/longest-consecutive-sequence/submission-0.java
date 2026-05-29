class Solution {
    public int longestConsecutive(int[] nums) { //Use sol 4
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;

        for(int num : nums){
            if(!mp.containsKey(num)){
                mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);

                //Update left boundary than w/ same length as the num
                mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num)) ;

                //Update right boundary
                mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num)) ;

                res = Math.max(res, mp.get(num));
            }
        }

        return res;
    }
}
