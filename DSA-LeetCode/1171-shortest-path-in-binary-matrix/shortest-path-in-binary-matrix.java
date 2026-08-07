class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // Edge cases
        if (n == 0 || grid[0][0] != 0 || grid[n-1][n-1] != 0) {
            return -1;
        }
        
        // If only one cell
        if (n == 1) {
            return 1;
        }
        
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // row, col, distance
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            
            // If reached destination
            if (r == n - 1 && c == n - 1) {
                return dist;
            }
            
            // Explore all 8 directions
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                
                if (isValid(newR, newC, n, visited) && grid[newR][newC] == 0) {
                    visited[newR][newC] = true;
                    queue.offer(new int[]{newR, newC, dist + 1});
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValid(int r, int c, int n, boolean[][] visited) {
        return r >= 0 && r < n && c >= 0 && c < n && !visited[r][c];
    }
}