class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);

        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            int start = binarySearch(products, prefix);
            List<String> suggestions = new ArrayList<>();

            for (int i = start; i < Math.min(start + 3, products.length); i++) {
                if (products[i].startsWith(prefix))
                    suggestions.add(products[i]);
                else
                    break;
            }
            ans.add(suggestions);
        }
        return ans;
    }

    private int binarySearch(String[] products, String prefix) {
        int left = 0;
        int right = products.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (products[mid].compareTo(prefix) >= 0)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}