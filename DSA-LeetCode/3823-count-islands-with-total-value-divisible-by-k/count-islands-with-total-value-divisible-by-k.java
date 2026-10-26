class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If it's part of an island and not visited yet
                if (grid[i][j] != 0 && !visited[i][j]) {
                    // Get the total sum of this entire island
                    long islandSum = helper(grid, visited, i, j);
                    
                    // Check if the sum is divisible by k
                    if (islandSum % k == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private long helper(int[][] grid, boolean[][] visited, int r, int c) {
        // Base case: out of bounds, water, or already visited
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
            || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        // Mark as visited
        visited[r][c] = true;

        // Start with the current cell's value
        long sum = grid[r][c];

        // Add the sums of all connected land cells (Up, Down, Left, Right)
        sum += helper(grid, visited, r - 1, c); // Up
        sum += helper(grid, visited, r + 1, c); // Down
        sum += helper(grid, visited, r, c - 1); // Left
        sum += helper(grid, visited, r, c + 1); // Right

        return sum;
    }
}