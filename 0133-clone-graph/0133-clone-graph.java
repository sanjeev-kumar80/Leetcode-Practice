/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        
        Node clone = new Node(node.val);

        map.put(node, clone);
        q.add(node);

        while (!q.isEmpty()) {

            Node curr = q.poll();

            for (Node neighbor : curr.neighbors) {

                // Agar neighbor ka clone abhi nahi bana
                if (!map.containsKey(neighbor)) {

                    Node newNode = new Node(neighbor.val);

                    map.put(neighbor, newNode);

                    q.add(neighbor);
                }

                // Clone ke neighbor mein cloned node add karo
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return clone;
    }
}