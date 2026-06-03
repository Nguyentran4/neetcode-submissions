class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(Character c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int l = 0; //left
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int have = 0;
        int need = countT.size();

        for(int r = 0; r < s.length(); r++){
            char rightChar = s.charAt(r);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if(countT.containsKey(rightChar) && window.get(rightChar) == countT.get(rightChar)){
                have++;
            }

            while(have == need){
                if((r - l + 1) < resLen){ //Check for the shortest len
                    resLen = (r - l + 1); //Update the range.
                    res[0] = l; //Note the left and right
                    res[1] = r;
                }

                //Shrink the range from the left. Until find the character needed.
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)){
                    have--; //get out of the while loop
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);


        
    }
}
