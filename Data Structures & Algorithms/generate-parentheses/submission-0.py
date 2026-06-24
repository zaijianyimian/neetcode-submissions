class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        path = []

        def backtrack(left: int, right: int) -> None:
            # 已经放满 n 对括号
            if left == n and right == n:
                ans.append("".join(path))
                return

            # 还能放左括号
            if left < n:
                path.append("(")
                backtrack(left + 1, right)
                path.pop()

            # 右括号不能比左括号多
            if right < left:
                path.append(")")
                backtrack(left, right + 1)
                path.pop()

        backtrack(0, 0)
        return ans