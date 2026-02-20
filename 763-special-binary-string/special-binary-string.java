class Solution {
  public String makeLargestSpecial(String s) {
    List<String> list = new ArrayList<>();
    int balance = 0, start = 0;

    for (int i = 0; i < s.length(); i++) {
      balance += s.charAt(i) == '1' ? 1 : -1;
      
      if (balance == 0) {
        // Recursively process inner substring
        String inner = makeLargestSpecial(s.substring(start + 1, i));
        list.add("1" + inner + "0");
        start = i + 1;
      }
    }

    // Sort descending to get lexicographically largest
    list.sort(Collections.reverseOrder());

    StringBuilder sb = new StringBuilder();
    for (String str : list) {
      sb.append(str);
    }

    return sb.toString();
  }
}