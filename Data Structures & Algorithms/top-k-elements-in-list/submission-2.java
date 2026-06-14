class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int  i = 0;i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] arr = new List[nums.length + 1];
        //map忘记怎么遍历了
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            int key = entry.getKey();
            int count = entry.getValue();
            if(arr[count] == null){
                arr[count] = new ArrayList<Integer>();
            }
            arr[count].add(key);
        }
        int index = 0;
        int[] ans = new int[k];
        for(int i = arr.length - 1;i  >= 0;i --){
            if(arr[i] == null){
                continue;
            }
            for(int num : arr[i]){
                ans[index ++] = num;
                if(index == k){
                    return ans;
                }
            }
        }
        return ans;
    }
}
