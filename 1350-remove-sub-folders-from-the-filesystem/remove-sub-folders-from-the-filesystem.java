class Solution {
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        for (String path : folder) {
            insert(root, path);
        }
        List<String> result = new ArrayList<>();
        collectPaths(root, "", result);
        return result;
    }

    private void insert(TrieNode node, String path) {
        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.isEmpty())
                continue;
            node.children.putIfAbsent(part, new TrieNode());
            node = node.children.get(part);
            if (node.isEnd)
                return;
        }
        node.isEnd = true;
        node.children.clear();
    }

    private void collectPaths(TrieNode node, String path, List<String> result) {
        if (node.isEnd) {
            result.add(path);
            return;
        }
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            collectPaths(entry.getValue(), path + "/" + entry.getKey(), result);
        }
    }

    private static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }
}
