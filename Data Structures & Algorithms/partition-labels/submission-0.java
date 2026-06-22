class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];

        // Step 1: store last occurrence of each char
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int start = 0;
        int end = 0;

        // Step 2: greedy scan
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // when we reach the boundary, cut
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}