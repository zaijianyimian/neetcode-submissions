class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return ans;
    }
    public void backtrack(int[] nums){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return ;
        }
        for(int i = 0;i < nums.length;i ++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
