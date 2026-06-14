class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new Set[9];
        Set<Character>[] col = new Set[9];
        Set<Character>[] box = new Set[9];
        for(int i = 0;i < 9;i ++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for(int r = 0; r < board.length;r ++){
            for(int c = 0;c < board[0].length;c ++){
                char tmp = board[r][c];
                if(tmp == '.'){
                    continue;
                }
                int boxIndex  = (r / 3) * 3 + c / 3;
                if(row[r].contains(tmp) || col[c].contains(tmp) || box[boxIndex].contains(tmp)){
                    return false;
                }
                row[r].add(tmp);
                col[c].add(tmp);
                box[boxIndex].add(tmp);
            }
        }
        return true;
    }
}
