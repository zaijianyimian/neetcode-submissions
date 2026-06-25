class TreeNode:
    def __init__(self) -> None:
        self.child = {}
        self.endword = None
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TreeNode()
        for word in words:
            cur = root
            for c in word:
                if c not in cur.child:
                    cur.child[c] = TreeNode()
                cur = cur.child[c]
            cur.endword = word
        row,col = len(board),len(board[0])
        ans = []
        def dfs(r: int,c : int,node:TreeNode) -> None:
            nonlocal row,col,ans
            if (r < 0 or r >= row or c < 0 or c >= col or board[r][c] not in node.child):
                return
            ch = board[r][c]
            node = node.child[ch]
            if node.endword is not None:
                ans.append(node.endword)
                node.endword = None
            board[r][c] = "#"
            dir = {(1,0),(-1,0),(0,1),(0,-1)}
            for dr,dc in dir:
                nr = r + dr
                nc = c + dc
                if 0 <= nr < row and 0 <= nc < col and board[nr][nc] != "#":
                    dfs(nr,nc,node)
            board[r][c] = ch
        for r in range(row):
            for c in range(col):
                dfs(r,c,root)
        return ans
        