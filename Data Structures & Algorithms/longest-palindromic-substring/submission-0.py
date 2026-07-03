class Solution:
    def longestPalindrome(self, s: str) -> str:
        def check(i : int,j : int) -> int:
            while (i >= 0 and j < len(s) and s[i] == s[j]):
                i -= 1
                j += 1
            return j - i - 1
        ans = 0
        start = 0
        end = 0
        for i in range(len(s)):
            len1 = check(i,i)
            len2 = check(i,i + 1)
            maxlen = max(len1,len2)
            if maxlen > ans:
                ans = maxlen
                start = i - (maxlen - 1) // 2
                end = i + maxlen // 2
        return s[start: end + 1]