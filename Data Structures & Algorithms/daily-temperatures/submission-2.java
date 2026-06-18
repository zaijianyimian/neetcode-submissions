class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for(int i = 0;i < n;i ++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                arr[index] = i - index;
            }
            stack.push(i);
        }
        return arr;
    }
}
