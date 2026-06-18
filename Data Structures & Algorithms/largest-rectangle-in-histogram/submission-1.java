class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0;i < n;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int index = stack.pop();
                int left = stack.isEmpty() ? -1: stack.peek();
                int height = heights[index];
                int width  = i - left - 1; 
                maxArea = Math.max(maxArea,width * height);
            } 
            stack.push(i);
        }
        while(! stack.isEmpty()){
            int index = stack.pop();
            int left = stack.isEmpty()?-1:stack.peek();
            int height = heights[index];
            int width = n - left - 1;
            maxArea = Math.max(maxArea,height * width);
        }
        return maxArea;
    }
}
