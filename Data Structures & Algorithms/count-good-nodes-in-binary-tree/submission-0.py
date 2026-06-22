# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if root == None:
            return 0
        ans = 0
        def dfs(node: TreeNode,mx: int):
            nonlocal ans
            if node == None:
                return
            elif mx <= node.val:
                ans += 1
            mx = max(mx,node.val)
            dfs(node.left,mx)
            dfs(node.right,mx)
        dfs(root,root.val)
        return ans
