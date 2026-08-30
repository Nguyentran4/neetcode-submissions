class Solution {
    public List<Integer> partitionLabels(String s) { //Two pointer
        HashMap<Character, Integer> lastIndex = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();

        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if(i == end){
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;

    } //Expand window using last occurrence;
    //close partition when index hits farthest last index of all seen characters.
}
