class Solution {

    int ROW;
    int COL;
    int LEN;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        LEN = word.length();
        visited = new boolean[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (dfs(r, c, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int i, char[][] board, String word) {
        // 越界、重复经过、当前字符不匹配
        if (r < 0 || r >= ROW || c < 0 || c >= COL
                || visited[r][c]
                || board[r][c] != word.charAt(i)) {
            return false;
        }

        // 当前字符已经匹配，并且是最后一个字符
        if (i == LEN - 1) {
            return true;
        }

        visited[r][c] = true;

        boolean res =
                dfs(r + 1, c, i + 1, board, word)
                        || dfs(r - 1, c, i + 1, board, word)
                        || dfs(r, c + 1, i + 1, board, word)
                        || dfs(r, c - 1, i + 1, board, word);

        // 回溯：撤销当前格子的访问状态
        visited[r][c] = false;

        return res;
    }
}