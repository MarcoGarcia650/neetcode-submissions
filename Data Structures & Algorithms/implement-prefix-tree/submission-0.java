class PrefixTree {

    private class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }


    public void insert(String word) {
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
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }


    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        return node != null;
    }


    private TrieNode findNode(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';

            if(curr.children[index] == null){
                return null;
            }
            curr = curr.children[index];
        }
        return curr;
    }
}
