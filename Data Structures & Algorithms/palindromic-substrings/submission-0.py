class Solution:
    def countSubstrings(self, s: str) -> int:
        ans = 0
        def check(left:int,right: int) -> int:
            nonlocal ans
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return right - left - 1
        for i in range(len(s)):
            len1 = check(i,i)
            len2 = check(i,i + 1)
            ans += (len1 + 1)//2 + len2 // 2
        return ans 