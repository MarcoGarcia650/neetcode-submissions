class WordDictionary {

    private class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;


    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // make dfs

    private boolean dfs(String word, int i, TrieNode node){
        if(node == null) return false;

        if(i == word.length()) return node.isEnd;

        char c = word.charAt(i);

        if(c == '.'){
            for(TrieNode child : node.children){
                if(dfs(word, i + 1, child)){
                    return true;
                }
            }
            return false;
        } else {
            int index = c - 'a';
            return dfs(word, i + 1, node.children[index]);
        }
    }
}
