class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s2) < len(s1) :
            return False
        arr = [0] * 26
        for c in s1:
            arr[ord(c) - ord('a')] += 1
        l,r = 0,0
        while r < len(s2):
            index = ord(s2[r]) - ord('a')
            arr[index] -= 1
            while arr[index] < 0:
                lindex = ord(s2[l]) - ord('a')
                arr[lindex] += 1
                l += 1
            length = r - l + 1
            if(length == len(s1)):
                for i in arr:
                    if i != 0:
                        return False
                return True
            r += 1
        return False