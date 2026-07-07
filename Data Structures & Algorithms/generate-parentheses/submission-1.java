class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        dfs(ans, n ,sb , 0, 0);
        return ans;
    }

    private void dfs(List<String> ans, int n, StringBuilder sb, int open, int close) {
        if (close == open && open == n) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            dfs(ans, n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            dfs(ans, n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
