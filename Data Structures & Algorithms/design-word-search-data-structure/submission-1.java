class TreeNode{
    Map<Character,TreeNode> child = new HashMap<>();
    boolean isend = false;
}
class WordDictionary {
    private TreeNode root;
    public WordDictionary() {
        this.root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode cur = root;
        for(char c : word.toCharArray()){
            cur.child.putIfAbsent(c, new TreeNode());
            cur = cur.child.get(c);
        }
        cur.isend = true;
    }

    public boolean search(String word) {
        return dfs(0,word,root);
    }

    public boolean dfs(int i,String word,TreeNode node){
        if(i == word.length()){
            return node.isend;
        }
        char c = word.charAt(i);
        if(c == '.'){
            for(TreeNode no : node.child.values()){
                if(dfs(i + 1,word,no)){
                    return true;
                }
            }
            return false;
        }
        else{
            if(node.child.get(c) == null){
                return false;
            }
            else{
                return dfs(i + 1,word,node.child.get(c));
            }
        }
    }
}
