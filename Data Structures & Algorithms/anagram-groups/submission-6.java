class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for(String s : strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            mp.putIfAbsent(sorted, new ArrayList<>());
            mp.get(sorted).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}
