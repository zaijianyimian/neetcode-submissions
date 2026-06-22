# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        ans = float('-inf')
        def dfs(node:TreeNode) -> int:
            nonlocal ans
            if node == None:
                return 0
            left = max(dfs(node.left),0)
            right = max(dfs(node.right),0)

            sum = node.val + left + right
            if(sum > ans):
                ans = sum
            return node.val + max(left,right)
        dfs(root)
        return ans

