class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        return Math.max(help(Arrays.copyOfRange(nums,1,n)),help(Arrays.copyOfRange(nums,0,n - 1)));
    }
    public int help(int[] nums){
        int dp0 = 0;
        int dp1 = 0;
        for(int num : nums){
            int tmp = Math.max(dp0 + num,dp1);
            dp0 = dp1;
            dp1 = tmp;
        }
        return dp1;
    }
}
