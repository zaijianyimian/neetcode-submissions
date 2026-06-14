class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>(); //不能用数组做key，用排序后的字符串做key
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            //转换成字符串的函数又忘了
            String tmp = new String(arr);
            map.computeIfAbsent(tmp,k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
