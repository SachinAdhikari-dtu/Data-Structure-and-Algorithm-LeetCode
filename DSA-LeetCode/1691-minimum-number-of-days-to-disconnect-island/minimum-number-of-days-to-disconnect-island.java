class Solution {
    private int rows, cols;
    private int[][] grid;
    private int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int minDays(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        
        // Count initial islands
        int islands = countIslands();
        
        // If already disconnected or no land
        if (islands != 1) return 0;
        
        // Check if we can disconnect by removing one cell (articulation point)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // Remove this cell
                    grid[i][j] = 0;
                    
                    // Check if removing this cell disconnects the graph
                    if (countIslands() != 1) {
                        grid[i][j] = 1; // restore
                        return 1; // Found an articulation point
                    }
                    
                    grid[i][j] = 1; // restore
                }
            }
        }
        
        // If no articulation point found, need 2 days
        return 2;
    }
    
    private int countIslands() {
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(i, j, visited);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(newRow, newCol, visited);
            }
        }
    }
}