class Solution {
    public static int helper(boolean istrue[], int grid[][], boolean arr[][], int r, int c, int d[][]) {
        // Mark current cell as visited
        arr[r][c] = true;
        
        // If we hit the boundary, this whole island is not an enclave
        if (r == 0 || r == arr.length - 1 || c == 0 || c == arr[0].length - 1) {
            istrue[0] = true;
        }

        int count = 1; // Count the current cell

        for (int i = 0; i < 4; i++) {
            int row = r + d[i][0];
            int col = c + d[i][1];

            // Check bounds, if it's land, and if it's not visited
            if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {
                if (grid[row][col] == 1 && !arr[row][col]) {
                    // Add the count of the connected land to our total
                    count += helper(istrue, grid, arr, row, col, d);
                }
            }
        }

        return count;
    }

    public int numEnclaves(int[][] grid) {
        boolean arr[][] = new boolean[grid.length][grid[0].length];
        boolean include[] = new boolean[1];
        int d[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                // If it's land and not visited
                if (grid[i][j] == 1 && !arr[i][j]) {
                    include[0] = false; // Reset flag for this new island
                    
                    int curr = helper(include, grid, arr, i, j, d);
                    
                    // If the island didn't touch the boundary, add its size
                    if (!include[0]) {
                        ans += curr;
                    }
                }
            }
        }
        return ans;
    }
}