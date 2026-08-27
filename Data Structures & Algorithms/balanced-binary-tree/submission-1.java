/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;

        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode cur, boolean[] res){
        if(cur == null) return 0;

        int left = dfs(cur.left, res);
        int right = dfs(cur.right, res);

        if(Math.abs(right - left) > 1){
            res[0] = false;
        }

        return 1 + Math.max(left, right);
    }
}
