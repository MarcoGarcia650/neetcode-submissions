class Solution {

    private class TrieNode{
        // only  need children and word
        TrieNode[] children;
        String word;
        
        TrieNode(){ 
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // build trie from words
        TrieNode root = new TrieNode();

        for(String word : words){
            TrieNode curr = root;

            for(char c : word.toCharArray()){
                int index = c - 'a';

                if(curr.children[index] == null){
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            // looped ended, curr is sitting on last char node
            // store full word here so we can add it to result when found
            curr.word = word;
        }

        int rows = board.length;
        int cols = board[0].length;

        // try starting dfs from every board cell
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result){
        // out of bounds check
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;

        char temp = board[r][c];

        // already visited this path
        if(temp == '#') return;

        int index = temp - 'a';

        // this board char path DNE in trie, stop search
        if(node.children[index] == null) return;

        // move node down this char path
        node = node.children[index];

        // if word is not null, found full word
        if(node.word != null){
            result.add(node.word);
            // set to null so we dont add duplicate word to result
            node.word = null;
        }

        // mark cell as visited so this path doesnt reuse it
        board[r][c] = '#';

        // search neighbhors
        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        // restire cell so other paths can use it
        board[r][c] = temp;
    }
}
