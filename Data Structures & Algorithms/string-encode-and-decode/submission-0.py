class Solution:

    def encode(self, strs: List[str]) -> str:
        ans = ""
        for st in strs:
            ans += str(len(st)) + '#' + st
        return ans
        

    def decode(self, s: str) -> List[str]:
        ans,i = [],0
        while i < len(s):
            j = i
            while s[j] != '#':
                j += 1
            length = int(s[i:j])
            i = j + 1
            ans.append(s[i:i + length])
            i = i + length
        return ans
            