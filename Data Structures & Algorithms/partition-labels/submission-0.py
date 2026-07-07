class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        dic = {}
        for i, c in enumerate(s):
            dic[c] = i
        tmp = 0
        maxAppear = 0
        ans = []
        for i in range(len(s)):
            maxAppear = max(maxAppear,dic[s[i]])
            tmp += 1
            if maxAppear == i:
                ans.append(tmp)
                tmp = 0
        return ans