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

    private int maxDepthc;
    public int maxDepth(TreeNode root) {
        return maxDepthCount(root, 0);
    }

    private int maxDepthCount(TreeNode root, int max){
        if(root == null) return max;

        maxDepthc = Math.max(maxDepthCount(root.left, max + 1), maxDepthCount(root.right, max + 1));
        return maxDepthc;
    }
}
