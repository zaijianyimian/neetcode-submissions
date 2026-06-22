
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // 前序第一个节点一定是当前子树根节点
        int val = preorder[0];
        TreeNode root = new TreeNode(val);

        // 在中序数组中找到根节点位置
        int ind = 0;
        while (inorder[ind] != val) {
            ind++;
        }

        // 左子树节点数量 = ind
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, ind + 1),
                Arrays.copyOfRange(inorder, 0, ind)
        );

        root.right = buildTree(
                Arrays.copyOfRange(preorder, ind + 1, preorder.length),
                Arrays.copyOfRange(inorder, ind + 1, inorder.length)
        );

        return root;
    }
}