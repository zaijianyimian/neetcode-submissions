
class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
    String endWord = null;
}

class Solution {
    TrieNode root = new TrieNode();
    List<String> ans = new ArrayList<>();

    char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;

        for (String word : words) {
            addWord(word);
        }

        int row = board.length;
        int col = board[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                dfs(r, c, row, col, root);
            }
        }

        return ans;
    }

    public void dfs(int r, int c, int row, int col, TrieNode node) {
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] == '#'
            || !node.child.containsKey(board[r][c])) {
            return;
        }

        char ch = board[r][c];

        node = node.child.get(ch);

        if (node.endWord != null) {
            ans.add(node.endWord);
            node.endWord = null;
        }

        board[r][c] = '#';
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];

            dfs(nr, nc, row, col, node);
        }
        board[r][c] = ch;
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            cur.child.putIfAbsent(c, new TrieNode());
            cur = cur.child.get(c);
        }

        cur.endWord = word;
    }
}