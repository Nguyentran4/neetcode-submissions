class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            mp.putIfAbsent(sorted, new ArrayList<>());
            mp.get(sorted).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}
