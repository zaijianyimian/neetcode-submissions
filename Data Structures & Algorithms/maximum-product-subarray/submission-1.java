class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1,curMin = 1;
        for (int num : nums){
            int tmp = curMax * num;
            curMax = Math.max(num,Math.max(curMin * num,tmp));
            curMin = Math.min(num,Math.min(curMin * num,tmp));
            res = Math.max(res,curMax);
        }
        return res;
    }
}
