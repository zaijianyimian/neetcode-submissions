class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i ++){
            map.put(s.charAt(i),i);
        }

        List<Integer> ans = new ArrayList<>();
        int tmp = 0;
        int maxAppear = 0;
        for(int i = 0;i < s.length();i ++){
            maxAppear = Math.max(maxAppear,map.get(s.charAt(i)));
            tmp ++;
            if(maxAppear == i){
                ans.add(tmp);
                tmp = 0;
            }
        }
        return ans;
    }
}
