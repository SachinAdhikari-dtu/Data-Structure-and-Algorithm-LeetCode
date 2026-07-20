class Solution {

    public static boolean helper(int r, int c, int[][] arr, boolean[][] visited, int[][] d, boolean isPacific) {
        visited[r][c] = true;
        boolean atBorder = isPacific
            ? (r == 0 || c == 0)
            : (r == arr.length - 1 || c == arr[0].length - 1);
        if (atBorder) return true;

        for (int i = 0; i < 4; i++) {           // all 4 directions, not 2
            int row = r + d[i][0];
            int col = c + d[i][1];
            if (isValid(row, col, visited)) {
                if (arr[row][col] > arr[r][c]) continue;
                if (helper(row, col, arr, visited, d, isPacific)) return true;
            }
        }
        visited[r][c] = false;
        return false;
    }

    public static boolean isValid(int r, int c, boolean[][] arr) {
        return r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && !arr[r][c];
    }

    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};  // all 4 directions
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int c = 0; c < n; c++) {
                boolean canPacific = helper(i, c, arr, new boolean[m][n], d, true);
                boolean canAtlantic = helper(i, c, arr, new boolean[m][n], d, false);
                if (canPacific && canAtlantic) {
                    list.add(Arrays.asList(i, c));
                }
            }
        }
        return list;
    }
}