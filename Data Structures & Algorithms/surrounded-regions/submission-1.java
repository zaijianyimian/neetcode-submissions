class Solution {
    private int m;
    private int n;
    private char[][] board;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        this.board = board;
        m = board.length;
        n = board[0].length;

        // 从左右边界开始 DFS
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }

        // 从上下边界开始 DFS
        for (int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }

        // O 是被包围区域，# 是安全区域
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'X') {
                    continue;
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        if (
            i < 0 || i >= m ||
            j < 0 || j >= n ||
            board[i][j] != 'O'
        ) {
            return;
        }

        board[i][j] = '#';

        dfs(i + 1, j);
        dfs(i, j + 1);
        dfs(i - 1, j);
        dfs(i, j - 1);
    }
}