# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(root: Optional[TreeNode]) -> int:
            if(root == None):
                return 0
            leftLength = dfs(root.left)
            if leftLength == -1:
                return -1
            rightLength = dfs(root.right)
            if(rightLength == -1):
                return -1
            if abs(leftLength - rightLength) > 1:
                return -1
            return max(rightLength,leftLength) + 1
        return dfs(root) != -1