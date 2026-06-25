class TreeNode{
    Map<Character,TreeNode> children = new HashMap<>();
    boolean end = false;
}
class PrefixTree {
    private TreeNode root;
    public PrefixTree() {
         this.root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c,new TreeNode());
            cur = cur.children.get(c);

        }
        cur.end = true;

    }

    public boolean search(String word) {
        TreeNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for(char c : prefix.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
