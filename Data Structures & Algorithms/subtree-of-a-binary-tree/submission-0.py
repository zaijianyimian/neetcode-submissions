# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=, Self0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None:
            return False

        # 当前 root 能不能作为 subRoot 的根
        if self.dfs(root, subRoot):
            return True

        # 当前不行，继续去左右子树找候选起点
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def dfs(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if p is None and q is None:
            return True

        if p is None or q is None:
            return False

        if p.val != q.val:
            return False

        return self.dfs(p.left, q.left) and self.dfs(p.right, q.right)