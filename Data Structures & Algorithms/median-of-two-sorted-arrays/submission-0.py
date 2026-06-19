class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        # 保证 nums1 是较短数组
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)

        m, n = len(nums1), len(nums2)
        left_size = (m + n + 1) // 2

        l, r = 0, m

        while l <= r:
            i = (l + r) // 2
            j = left_size - i

            nums1_left = float("-inf") if i == 0 else nums1[i - 1]
            nums1_right = float("inf") if i == m else nums1[i]

            nums2_left = float("-inf") if j == 0 else nums2[j - 1]
            nums2_right = float("inf") if j == n else nums2[j]

            if nums1_left <= nums2_right and nums2_left <= nums1_right:
                if (m + n) % 2 == 1:
                    return max(nums1_left, nums2_left)
                else:
                    left_max = max(nums1_left, nums2_left)
                    right_min = min(nums1_right, nums2_right)
                    return (left_max + right_min) / 2

            elif nums1_left > nums2_right:
                r = i - 1
            else:
                l = i + 1
