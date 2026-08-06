class Solution {

    class Pair {
        int node;
        int cost;
        int stop;

        Pair(int node, int cost, int stop) {
            this.node = node;
            this.cost = cost;
            this.stop = stop;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2], 0));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0, 0));

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            if (cur.stop > k) continue;

            for (Pair next : adj.get(cur.node)) {

                int newCost = cur.cost + next.cost;

                if (newCost < dist[next.node]) {
                    dist[next.node] = newCost;
                    q.offer(new Pair(next.node, newCost, cur.stop + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}