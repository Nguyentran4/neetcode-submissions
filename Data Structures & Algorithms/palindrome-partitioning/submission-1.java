class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList();
        List<List<String>> ans = new ArrayList();

        dfs(s, 0, list, ans);
        return ans;
    }

    private void dfs(String s, int index, List<String> list, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList(list));
            return;
        }

        for (int i = index ; i < s.length() ; i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                dfs(s, i + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (end >= start) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
