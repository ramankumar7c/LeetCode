class TrieNode {
    public Map<String, TrieNode> children = new HashMap<>();
    public boolean deleted = false;
}

class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();

        Collections.sort(paths, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {
                int sizeCompare = Integer.compare(a.size(), b.size());
                if (sizeCompare != 0)
                    return sizeCompare;

                for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                    int stringCompare = a.get(i).compareTo(b.get(i));
                    if (stringCompare != 0)
                        return stringCompare;
                }
                return 0;
            }
        });

        for (List<String> path : paths) {
            TrieNode node = root;
            for (String dir : path) {
                if (!node.children.containsKey(dir))
                    node.children.put(dir, new TrieNode());

                node = node.children.get(dir);
            }
        }

        Map<String, List<TrieNode>> subtreeToNodes = new HashMap<>();

        serializeSubtrees(root, subtreeToNodes);

        for (List<TrieNode> nodes : subtreeToNodes.values()) {
            if (nodes.size() > 1)
                for (TrieNode node : nodes)
                    node.deleted = true;
        }

        List<List<String>> result = new ArrayList<>();
        constructPaths(root, new ArrayList<>(), result);

        return result;
    }

    private String serializeSubtrees(TrieNode node, Map<String, List<TrieNode>> subtreeToNodes) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        List<String> childNames = new ArrayList<>(node.children.keySet());
        Collections.sort(childNames);
        for (String dir : childNames) {
            TrieNode child = node.children.get(dir);
            sb.append(dir).append(serializeSubtrees(child, subtreeToNodes));
        }
        sb.append(")");
        String serialized = sb.toString();
        if (!serialized.equals("()")) {
            subtreeToNodes.putIfAbsent(serialized, new ArrayList<>());
            subtreeToNodes.get(serialized).add(node);
        }
        return serialized;
    }

    private void constructPaths(TrieNode node, List<String> currentPath, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String dir = entry.getKey();
            TrieNode child = entry.getValue();
            if (!child.deleted) {
                currentPath.add(dir);
                result.add(new ArrayList<>(currentPath));
                constructPaths(child, currentPath, result);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }
}