class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rowl,rowr = 0,len(matrix) - 1
        row = 0
        n = len(matrix[0])
        while rowl <= rowr:
            mid = (rowl + rowr) // 2
            if(matrix[mid][0] <= target and matrix[mid][n - 1] >= target):
                row = mid
                break
            elif(matrix[mid][0] > target):
                rowr = mid - 1
            else:
                rowl = mid + 1
        if(row < 0 or row > len(matrix)):
            return False
        l,r = 0,n - 1
        while l <= r:
            mid = (l + r) // 2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        return False