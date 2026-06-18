class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        stack = []
        maxArea = 0
        for i,height in enumerate(heights):
            while stack and heights[stack[-1]] >= height:
                index =  stack.pop()
                h = heights[index]
                left = stack[-1] if stack else -1
                width = i - left - 1
                maxArea = max(maxArea,width * h)
            stack.append(i)
        while stack:
            index = stack.pop()
            h = heights[index]
            left = stack[-1] if stack else -1
            width = len(heights) - left - 1
            maxArea = max(maxArea,width * h)
        return  maxArea

            