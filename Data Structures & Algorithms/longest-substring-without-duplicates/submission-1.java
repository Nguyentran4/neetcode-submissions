class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        int left = 0;
        int longestSS = 0;
        for(int r = 0; r < s.length(); r++){
            char cur = s.charAt(r);

            if(mp.containsKey(cur)){
                left = Math.max(left, mp.get(cur) + 1);
            }

            mp.put(cur, r);
            longestSS = Math.max(longestSS, r - left + 1);
        }

        return longestSS;
    }
}
