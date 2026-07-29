class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        int[] result = new int[2];
        
        // Cyclic sort directly on 2D array
        int i = 0;
        while (i < N) {
            // Get current position in 2D
            int currentRow = i / n;
            int currentCol = i % n;
            int currentVal = grid[currentRow][currentCol];
            
            // If current value is already at correct position
            if (currentVal == i + 1) {
                i++;
                continue;
            }
            
            // Calculate where currentVal should be
            int correctPos = currentVal - 1;
            int correctRow = correctPos / n;
            int correctCol = correctPos % n;
            
            // If the target position already has the correct value, we found duplicate
            if (grid[correctRow][correctCol] == currentVal) {
                result[0] = currentVal; // repeated
                i++;
            } else {
                // Swap current value with the value at its correct position
                int temp = grid[currentRow][currentCol];
                grid[currentRow][currentCol] = grid[correctRow][correctCol];
                grid[correctRow][correctCol] = temp;
            }
        }
        
        // Find the missing number
        for (i = 0; i < N; i++) {
            int row = i / n;
            int col = i % n;
            if (grid[row][col] != i + 1) {
                result[1] = i + 1; // missing
                break;
            }
        }
        
        return result;
    }
}