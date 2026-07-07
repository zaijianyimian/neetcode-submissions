class Solution {
    public int maxSubArray(int[] nums) {
        int total = nums[0];
        int ans = nums[0];
        for(int i = 1;i < nums.length;i ++){
            if(total + nums[i] < nums[i]){
                total = nums[i];
            }else{
                total += nums[i];
            }
            ans = Math.max(ans,total);
        }
        return ans;
    }
}
