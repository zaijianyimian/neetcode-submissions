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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return ans;
    }
    private void dfs(TreeNode node,int mx){
        if(node == null){
            return;
        }
        if(mx <= node.val){
            mx = node.val;
            ans ++;
        }
        dfs(node.left,mx);
        dfs(node.right,mx);
    }

}
