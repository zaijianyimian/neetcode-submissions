class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        arr = [0] * 26
        for c in s:
            index = ord(c) - ord('a')
            arr[index] += 1
        for c in t:
            index =  ord(c) - ord('a')
            arr[index] -= 1
            if arr[index] < 0:
                return False
        return True