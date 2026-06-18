class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] car = new int[n][2];
        for(int i = 0;i < n;i ++){
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }
        Arrays.sort(car,(a,b) -> a[0] - b[0]);
        Stack<Double> stack = new Stack<>();
        for(int i = n - 1;i >= 0;i --){
            int p = car[i][0];
            int s = car[i][1];
            double time = (double)(target - p) / s;
            stack.push(time);
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
