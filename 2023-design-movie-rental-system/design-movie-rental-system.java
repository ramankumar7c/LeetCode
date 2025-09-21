class MovieRentingSystem {
    private static class Entry {
        int price, shop, movie;

        Entry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }
    }

    private final Comparator<Entry> comp = Comparator.comparingInt((Entry e) -> e.price).thenComparingInt(e -> e.shop)
            .thenComparingInt(e -> e.movie);

    private final Map<Integer, TreeSet<Entry>> unrented = new HashMap<>();

    private final TreeSet<Entry> rented = new TreeSet<>(comp);

    private final Map<Long, Entry> entryMap = new HashMap<>();

    private long key(int shop, int movie) {
        return (((long) shop) << 32) | (movie & 0xffffffffL);
    }

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Entry entry = new Entry(price, shop, movie);
            entryMap.put(key(shop, movie), entry);
            unrented.computeIfAbsent(movie, k -> new TreeSet<>(comp)).add(entry);
        }
    }

    public List<Integer> search(int movie) {
        return unrented.getOrDefault(movie, new TreeSet<>()).stream().limit(5).map(e -> e.shop).toList();
    }

    public void rent(int shop, int movie) {
        Entry e = entryMap.get(key(shop, movie));
        unrented.get(movie).remove(e);
        rented.add(e);
    }

    public void drop(int shop, int movie) {
        Entry e = entryMap.get(key(shop, movie));
        rented.remove(e);
        unrented.get(movie).add(e);
    }

    public List<List<Integer>> report() {
        return rented.stream().limit(5).map(e -> List.of(e.shop, e.movie)).toList();
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */