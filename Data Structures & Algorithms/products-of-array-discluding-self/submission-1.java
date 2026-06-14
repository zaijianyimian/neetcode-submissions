class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rig = new int[n];
        Arrays.fill(rig,1);
        for(int i = n - 2;i >= 0;i --){
            rig[i] = nums[i + 1] * rig[i + 1];
        }
        int lef = 1;
        int[] ans = new int[n];
        for(int i = 0;i < n;i ++){
            ans[i] = lef * rig[i];
            lef *= nums[i];
        }
        return ans;
    }
}  
