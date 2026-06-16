from collections import defaultdict

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = defaultdict(int)
        window = defaultdict(int)

        for c in t:
            need[c] += 1

        l = 0
        valid = 0

        start = 0
        min_len = float("inf")

        for r in range(len(s)):
            c = s[r]

            # 右指针扩张窗口
            if c in need:
                window[c] += 1

                # 当前字符数量刚好满足要求
                if window[c] == need[c]:
                    valid += 1

            # 当窗口有效时，尝试收缩左边界
            while valid == len(need):
                # 更新最小答案
                if r - l + 1 < min_len:
                    start = l
                    min_len = r - l + 1

                d = s[l]

                # 左指针收缩窗口
                if d in need:
                    # 如果这个字符移出前刚好满足要求，移出后窗口就不合法了
                    if window[d] == need[d]:
                        valid -= 1

                    window[d] -= 1

                l += 1

        if min_len == float("inf"):
            return ""

        return s[start:start + min_len]