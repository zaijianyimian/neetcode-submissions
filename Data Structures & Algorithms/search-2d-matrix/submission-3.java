class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int m = matrix.length,n = matrix[0].length;
       int rowl = 0,rowr = m - 1,row = -1;
       while(rowl <= rowr){
            int midRow = (rowr - rowl) / 2 + rowl;
            if(matrix[midRow][0] <= target && matrix[midRow][n - 1] >= target){
                row = midRow;
                break;
            }else if (matrix[midRow][0] < target){
                rowl = midRow + 1;
            }else{
                rowr = midRow - 1;
            }
       }
       int l = 0,r = n - 1;
       if(row < 0 || row >= m){
        return false;
       }
       while(l <= r){
        int mid = (r - l) / 2 + l;
        if(matrix[row][mid] == target){
            return true;
        }else if(matrix[row][mid] > target){
            r = mid - 1;
        }else{
            l = mid + 1;
        }
       }
       return false;
    }
}
