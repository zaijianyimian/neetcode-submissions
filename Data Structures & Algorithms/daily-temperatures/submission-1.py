class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        nums = [0] * len(temperatures)
        stack = []
        for i in range(len(temperatures)):
            while(len(stack) > 0 and temperatures[stack[-1]] < temperatures[i]):
                index = stack.pop()
                nums[index] = i - index
            stack.append(i)
        return nums
