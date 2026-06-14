class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = collections.defaultdict(list)
        for s in strs:
            arr = list(s) # python中没有char
            arr.sort()
            tmp = "".join(arr)
            dic[tmp].append(s)
        return list(dic.values())