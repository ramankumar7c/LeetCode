class RandomizedSet {
    private List<Integer> elements;
    private Map<Integer, Integer> elementIndices;
    private Random random;

    public RandomizedSet() {
        elements = new ArrayList<>();
        elementIndices = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (elementIndices.containsKey(val))
            return false;

        elementIndices.put(val, elements.size());
        elements.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!elementIndices.containsKey(val))
            return false;

        int indexToRemove = elementIndices.get(val);
        int lastElement = elements.get(elements.size() - 1);

        elements.set(indexToRemove, lastElement);
        elementIndices.put(lastElement, indexToRemove);

        elements.remove(elements.size() - 1);
        elementIndices.remove(val);
        return true;
    }

    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */