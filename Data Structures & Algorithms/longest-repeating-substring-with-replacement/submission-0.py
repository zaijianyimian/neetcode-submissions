class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l,r = 0,0
        maxFreq = 0
        ans = 0
        count = collections.defaultdict(int)
        while r < len(s):
            count[s[r]] += 1
            maxFreq = max(maxFreq,count[s[r]])
            while r - l - maxFreq + 1 > k:
                count[s[l]] -= 1
                l += 1
            ans = max(ans,r - l + 1)
            r += 1
        return ans