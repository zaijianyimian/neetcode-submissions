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
        return dfs(root) != -1;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftLength = dfs(root.left);
        if(leftLength == -1){
            return -1;
        }
        int rightLength = dfs(root.right);
        if(rightLength == -1){
            return -1;
        }
        if(Math.abs(leftLength - rightLength) > 1){
            return -1;
        
        }
        return Math.max(leftLength,rightLength) + 1;
    }
}
