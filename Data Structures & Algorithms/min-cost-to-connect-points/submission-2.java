class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int cur = -1;

            // 找当前未访问且 minDist 最小的点
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (cur == -1 || minDist[j] < minDist[cur])) {
                    cur = j;
                }
            }

            visited[cur] = true;
            ans += minDist[cur];

            int x1 = points[cur][0];
            int y1 = points[cur][1];

            // 更新其他点到当前生成树的最小距离
            for (int nxt = 0; nxt < n; nxt++) {
                if (visited[nxt])
                    continue;

                int x2 = points[nxt][0];
                int y2 = points[nxt][1];

                int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                minDist[nxt] = Math.min(minDist[nxt], cost);
            }
        }

        return ans;
    }
}