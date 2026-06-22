/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }

        List<String> list = new ArrayList<>();

        // LinkedList 允许放 null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                list.add("N");
                continue;
            }

            list.add(String.valueOf(node.val));

            // 即使孩子为 null，也要入队，记录左右位置
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("N")) {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        // 反序列化时不会把 null 放入队列，因此可用 ArrayDeque
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < values.length) {
            TreeNode parent = queue.poll();

            // 处理左孩子
            if (!values[index].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[index]));
                parent.left = left;
                queue.offer(left);
            }
            index++;

            // 处理右孩子
            if (index < values.length && !values[index].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[index]));
                parent.right = right;
                queue.offer(right);
            }
            index++;
        }

        return root;
    }
}