class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, 0);
        }

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                if (!suppliesSet.contains(ingredient)) {
                    graph.putIfAbsent(ingredient, new ArrayList<>());
                    graph.get(ingredient).add(recipe);
                    inDegree.put(recipe, inDegree.getOrDefault(recipe, 0) + 1);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                queue.offer(entry.getKey());
        }

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current);
            if (graph.containsKey(current)) {
                for (String dependent : graph.get(current)) {
                    inDegree.put(dependent, inDegree.get(dependent) - 1);
                    if (inDegree.get(dependent) == 0)
                        queue.offer(dependent);
                }
            }
        }

        return result;
    }
}