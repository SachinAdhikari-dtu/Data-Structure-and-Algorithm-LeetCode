
class Solution {
    public static boolean check1(int r, int c, char[][] board) {
        char val = board[r][c];
        int i = 0;
        int j = 0;

        while (j < 9) {
            if (val == board[r][j] && j != c) return false;
            j++;
        }

        while (i < 9) {
            if (val == board[i][c] && i != r) return false;
            i++;
        }
        return true;
    }

    public static boolean check2(int r, int c, char[][] board) {
        char val = board[r][c];
        
        // ✅ Clean way to find the top-left of the 3x3 box
        int sr = (r / 3) * 3; 
        int sc = (c / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                // ✅ Use OR (||) to skip the exact same cell
                if (val == board[i][j] && (i != r || j != c)) return false;
            }
        }
        return true;
    }

    public static boolean helper(int r, char[][] board) {
        if (r == 9) return true;
        
        for (int i = 0; i < 9; i++) {
            if (board[r][i] != '.') { // ✅ Skip empty cells
                if (!check1(r, i, board) || !check2(r, i, board)) return false;
            }
        }
        return helper(r + 1, board);
    }

    public boolean isValidSudoku(char[][] board) {
        return helper(0, board);
    }
}