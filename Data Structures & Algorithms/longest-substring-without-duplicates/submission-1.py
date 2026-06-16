class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxLength = 0
        arr = [0] * 128
        l,r = 0,0
        while r < len(s):
            index = ord(s[r])
            arr[index] += 1
            while arr[index] > 1 and l < r:
                
                arr[ord(s[l])] -= 1
                l += 1
            r += 1
            maxLength = max(maxLength,r - l)
        return maxLength