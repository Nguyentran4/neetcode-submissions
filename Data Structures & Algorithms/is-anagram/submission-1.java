class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] t1 = s.toCharArray();
        char[] t2 = t.toCharArray();

        Arrays.sort(t1);
        Arrays.sort(t2);

        return Arrays.equals(t1, t2);
    }
}
