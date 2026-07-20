
class Solution {
    class pair {
        int r, c;
        pair(int r, int c) { this.r = r; this.c = c; }
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Queue<pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        // enqueue border O's
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') { q.offer(new pair(i, 0)); visited[i][0] = true; }
            if (board[i][cols-1] == 'O') { q.offer(new pair(i, cols-1)); visited[i][cols-1] = true; }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') { q.offer(new pair(0, j)); visited[0][j] = true; }
            if (board[rows-1][j] == 'O') { q.offer(new pair(rows-1, j)); visited[rows-1][j] = true; }
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!q.isEmpty()) {
            pair curr = q.poll();          // <-- must remove from queue
            int row = curr.r;
            int col = curr.c;

            for (int[] d : dirs) {
                int nr = row + d[0];
                int nc = col + d[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (visited[nr][nc] || board[nr][nc] != 'O') continue;

                visited[nr][nc] = true;
                q.offer(new pair(nr, nc));
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O' && !visited[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }
}