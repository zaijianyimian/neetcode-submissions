
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (String token : tokens) {
            if (!set.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop(); // 右操作数
                int num2 = stack.pop(); // 左操作数

                if (token.equals("+")) {
                    stack.push(num2 + num1);
                } else if (token.equals("-")) {
                    stack.push(num2 - num1);
                } else if (token.equals("*")) {
                    stack.push(num2 * num1);
                } else if (token.equals("/")) {
                    stack.push(num2 / num1);
                }
            }
        }

        return stack.pop();
    }
}