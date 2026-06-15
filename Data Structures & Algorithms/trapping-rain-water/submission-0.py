class Solution:
    def trap(self, height: List[int]) -> int:
        right = [0] * len(height)
        for i in range(len(height) - 2,-1,-1):
            right[i] = max(right[i + 1],height[i + 1])
        lef = 0
        ans = 0
        for i in range(len(height)):
            tmp = min(lef,right[i])
            water = tmp - height[i]
            if tmp < height[i]:
                water = 0
            lef = max(lef,height[i])
            ans += water
        return ans