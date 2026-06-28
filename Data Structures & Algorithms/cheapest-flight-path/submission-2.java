class Solution {
    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k
    ) {
        int INF = 1_000_000_000;

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // k 个中转 => 最多 k + 1 条边
        for (int i = 0; i <= k; i++) {
            int[] nextDist = dist.clone();

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (dist[from] == INF) {
                    continue;
                }

                nextDist[to] = Math.min(
                    nextDist[to],
                    dist[from] + price
                );
            }

            dist = nextDist;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}