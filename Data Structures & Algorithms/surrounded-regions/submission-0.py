class Solution:
    def solve(self, board: List[List[str]]) -> None:
        m ,n= len(board),len(board[0])
        def dfs(i,j):
            if (i < 0 or i >= m or j < 0 or j >= n or board[i][j] != 'O'):
                return 
            board[i][j] = '#'
            dfs(i + 1,j)
            dfs(i,j + 1)
            dfs(i - 1,j)
            dfs(i,j - 1)
        for i in range(m):
            dfs(i,0)
            dfs(i,n - 1)
        for j in range(n):
            dfs(0,j)
            dfs(m - 1,j)
        for r in range(m):
            for c in range(n):
                if(board[r][c] == 'X'):
                    continue
                elif board[r][c] == 'O':
                    board[r][c] = 'X'
                else:
                     board[r][c] = 'O'
                