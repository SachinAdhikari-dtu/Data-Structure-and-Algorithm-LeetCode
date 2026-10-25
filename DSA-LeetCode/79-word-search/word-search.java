class Solution {
    public boolean exist(char[][] board, String word) {
        
        return isWordExist(board,word);
    
    }
    
    public boolean isWordExist(char[][] mat, String word) {
        int rows = mat.length;
        int cols = mat[0].length;

        // 1. Loop through the entire grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the first character matches, start a DFS search
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    

    // DFS + Backtracking Helper
    private boolean dfs(char[][] mat, String word, int r, int c, int index) {
        // Base Case: If we have matched all characters
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and if the current character matches
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited by changing its character
        char temp = mat[r][c];
        mat[r][c] = '#'; // '#' means visited

        // Explore all 4 directions: Up, Down, Left, Right
        boolean found = dfs(mat, word, r - 1, c, index + 1) || // Up
                        dfs(mat, word, r + 1, c, index + 1) || // Down
                        dfs(mat, word, r, c - 1, index + 1) || // Left
                        dfs(mat, word, r, c + 1, index + 1);   // Right

        // Backtrack: Restore the original character
        mat[r][c] = temp;

        return found;
    }
}