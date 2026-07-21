class Solution {
    private int INF = 2147483647;
    private int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : directions) {
                int nRow = dir[0] + cur[0];
                int nCol = dir[1] + cur[1];
                if (nRow < 0 || nCol < 0 || nRow >= m || nCol >= n || grid[nRow][nCol] != INF) {
                    continue;
                }
                queue.offer(new int[]{nRow, nCol});
                grid[nRow][nCol] = grid[cur[0]][cur[1]] + 1;
            }
        }
    }
}
