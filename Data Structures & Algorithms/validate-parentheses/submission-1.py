class Solution:
    def isValid(self, s: str) -> bool:
        queue = []
        dic = {')':'(','}':'{',']':'['}
        for c in s:
            if c in dic:
                if queue and queue[-1] == dic[c]:
                    queue.pop()
                else:
                    return False
            else:
                queue.append(c)
        return len(queue) == 0