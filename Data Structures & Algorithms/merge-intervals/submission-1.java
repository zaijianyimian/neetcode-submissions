class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> {
            return a[0] - b[0];
        });
        ans.add(intervals[0]);
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            int lastEnd = ans.get(ans.size() - 1)[1];
            if(start <= lastEnd){
                ans.get(ans.size() - 1)[1] = Math.max(lastEnd,end);
            }else{
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
