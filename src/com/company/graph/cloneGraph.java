package com.company.graph;

import java.util.HashMap;
import java.util.Map;

public class cloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, Map<Integer, Node> map) {
        if(map.containsKey(node.val)) return map.get(node.val);
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for(Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }
        return copy;
    }
}
