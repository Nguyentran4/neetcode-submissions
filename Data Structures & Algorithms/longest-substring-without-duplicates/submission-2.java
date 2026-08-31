class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        int left = 0;
        int longSS = 0;

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);

            if(mp.containsKey(cur)){
                left = Math.max(left, mp.get(cur) + 1);
            }

            mp.put(cur, i);
            longSS = Math.max(longSS, i - left + 1);
        }

        return longSS;
    }
}
