class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastIn = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            lastIn.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int left = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, lastIn.get(s.charAt(i)));

            if(i == end){
                res.add(end - left + 1);
                left = end + 1;
            }
        }

        return res;
    }
}
