class Solution {
    class Node {
        int bestIdx;
        Node[] children = new Node[26];
        Node() {
            bestIdx = 0;
        }
    }
    
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Node root = new Node();
        
        // Insert container words (reversed)
        for (int i = 0; i < wordsContainer.length; i++) {
            String w = wordsContainer[i];
            Node node = root;
            
            // Update root's best index: shortest word overall
            if (wordsContainer[node.bestIdx].length() > w.length()) {
                node.bestIdx = i;
            }
            
            for (int j = w.length() - 1; j >= 0; j--) {
                int c = w.charAt(j) - 'a';
                if (node.children[c] == null) {
                    node.children[c] = new Node();
                    node.children[c].bestIdx = i;
                } else {
                    if (wordsContainer[node.children[c].bestIdx].length() > w.length()) {
                        node.children[c].bestIdx = i;
                    }
                }
                node = node.children[c];
            }
        }
        
        int[] ans = new int[wordsQuery.length];
        // Answer each query
        for (int i = 0; i < wordsQuery.length; i++) {
            String q = wordsQuery[i];
            Node node = root;
            for (int j = q.length() - 1; j >= 0; j--) {
                int c = q.charAt(j) - 'a';
                if (node.children[c] == null) break;
                node = node.children[c];
            }
            ans[i] = node.bestIdx;
        }
        return ans;
    }
}