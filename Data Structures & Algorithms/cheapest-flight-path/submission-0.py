from typing import List


class Solution:
    def findCheapestPrice(
        self,
        n: int,
        flights: List[List[int]],
        src: int,
        dst: int,
        k: int
    ) -> int:
        INF = float("inf")

        # dist[i]：当前最多使用若干条边，到 i 的最低价格
        dist = [INF] * n
        dist[src] = 0

        # 最多 k 个中转 = 最多 k + 1 次飞行
        for _ in range(k + 1):
            # 必须复制，防止本轮用到刚更新的数据
            next_dist = dist[:]

            for frm, to, price in flights:
                if dist[frm] == INF:
                    continue

                next_dist[to] = min(
                    next_dist[to],
                    dist[frm] + price
                )

            dist = next_dist

        return -1 if dist[dst] == INF else dist[dst]