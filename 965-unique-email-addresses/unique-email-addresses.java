class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@", 2);
            String localName = parts[0];
            localName = localName.replace(".", "");

            int index = localName.indexOf("+");
            if (index != -1)
                localName = localName.substring(0, index);

            uniqueEmails.add(localName + "@" + parts[1]);

        }
        return uniqueEmails.size();
    }
}