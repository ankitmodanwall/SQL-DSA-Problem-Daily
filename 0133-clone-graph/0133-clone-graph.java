class Solution {
    // Map to keep track of visited nodes and their clones
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If we have already processed this node, return its clone
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create the clone (empty neighbors list for now)
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Recursively clone all neighbors
        for (Node nei : node.neighbors) {
            clone.neighbors.add(cloneGraph(nei));
        }

        return clone;
    }
}