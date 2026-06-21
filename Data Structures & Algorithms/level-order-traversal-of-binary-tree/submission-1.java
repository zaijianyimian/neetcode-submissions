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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.addLast(root);
        while (queue.size() > 0) {
            int lenQ = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < lenQ; i++) {
                TreeNode node = queue.pollFirst();
                if (node != null) {
                    tmp.add(node.val);
                    if (node.left != null)
                        queue.addLast(node.left);
                    if (node.right != null)
                        queue.addLast(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
