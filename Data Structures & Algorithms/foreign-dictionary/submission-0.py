from typing import List
from collections import defaultdict, deque


class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        # 1. 先收集所有出现过的字符
        graph = {ch: set() for word in words for ch in word}
        indegree = {ch: 0 for ch in graph}

        # 2. 比较相邻单词，建立边
        for i in range(len(words) - 1):
            word1 = words[i]
            word2 = words[i + 1]

            # 前缀错误：abc 排在 ab 前面
            if len(word1) > len(word2) and word1.startswith(word2):
                return ""

            # 找第一个不同字符
            for c1, c2 in zip(word1, word2):
                if c1 != c2:
                    # c1 必须排在 c2 前
                    if c2 not in graph[c1]:
                        graph[c1].add(c2)
                        indegree[c2] += 1
                    break

        # 3. 拓扑排序
        queue = deque()

        for ch in indegree:
            if indegree[ch] == 0:
                queue.append(ch)

        ans = []

        while queue:
            ch = queue.popleft()
            ans.append(ch)

            for nxt in graph[ch]:
                indegree[nxt] -= 1

                if indegree[nxt] == 0:
                    queue.append(nxt)

        # 4. 有环则无法排序完整
        return "".join(ans) if len(ans) == len(graph) else ""