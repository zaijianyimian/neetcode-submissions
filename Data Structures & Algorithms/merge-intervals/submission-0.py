class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        ans = []
        intervals.sort(key=lambda x:x[0])
        ans.append(intervals[0])
        for i in range(1,len(intervals)):
            tmp = ans[-1][-1]
            if tmp < intervals[i][0]:
                ans.append(intervals[i])
            else:
                ans[-1][-1] = max(ans[-1][-1],intervals[i][1])
        return ans
                 