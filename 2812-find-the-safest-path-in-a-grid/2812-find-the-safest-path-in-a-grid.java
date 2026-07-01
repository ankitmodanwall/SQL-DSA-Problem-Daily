import java.util.*;

class Solution {
    int n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        boolean[][] vis = new boolean[n][n];

        // Step 1: Push all thief cells
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    vis[r][c] = true;
                    q.offer(new int[]{r, c});
                }
            }
        }

        // Multi-source BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (vis[nr][nc]) continue;

                dist[nr][nc] = dist[r][c] + 1;
                vis[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }

        // Step 2: Max heap
        PriorityQueue<int[]> store = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        boolean[][] vis2 = new boolean[n][n];
        store.offer(new int[]{dist[0][0], 0, 0});

        while (!store.isEmpty()) {
            int[] curr = store.poll();
            int safeE = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (vis2[r][c]) continue;
            vis2[r][c] = true;

            if (r == n - 1 && c == n - 1) return safeE;

            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (vis2[nr][nc]) continue;

                int newSafe = Math.min(safeE, dist[nr][nc]);
                store.offer(new int[]{newSafe, nr, nc});
            }
        }

        return 0;
    }
}