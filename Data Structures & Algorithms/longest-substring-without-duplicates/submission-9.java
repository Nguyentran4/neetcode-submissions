class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l = 0, res = 0;

        for(int i = 0; i < s.length(); i++){
            if(mp.containsKey(s.charAt(i))){
                l = Math.max(l, mp.get(s.charAt(i)) + 1);
            }

            mp.put(s.charAt(i), i);
            res = Math.max(res, i - l + 1);
        }

        return res;
    }
}
