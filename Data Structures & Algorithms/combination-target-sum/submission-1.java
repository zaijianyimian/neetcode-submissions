class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0,nums,target);
        return ans;
    }
    public void backtrack(int start,int[] nums,int target){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }else if(target < 0){
            return ;
        }
        for(int i = start;i < nums.length;i ++){
            path.add(nums[i]);
            backtrack(i,nums,target - nums[i]);
            path.removeLast();
        }
    }
}
