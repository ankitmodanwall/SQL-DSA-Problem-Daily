class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        long INF = Long.MAX_VALUE / 2;

        long[][] dist = new long[n][k + 1];

        for (long[] row : dist)
            Arrays.fill(row, INF);

        // {cost, node, consecutiveCount}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            long cost = cur[0];
            int u = (int) cur[1];
            int cnt = (int) cur[2];

            if (cost != dist[u][cnt])
                continue;

            if (u == n - 1)
                return (int) cost;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int weight = edge[1];

                int newCnt;

                if (labels.charAt(u) == labels.charAt(v))
                    newCnt = cnt + 1;
                else
                    newCnt = 1;

                if (newCnt > k)
                    continue;

                long newCost = cost + weight;

                if (newCost < dist[v][newCnt]) {
                    dist[v][newCnt] = newCost;
                    pq.offer(new long[]{newCost, v, newCnt});
                }
            }
        }

        return -1;
    }
}