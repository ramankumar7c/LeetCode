class Solution {
    class Person {
        int height;
        String name;

        Person(int height, String name) {
            this.height = height;
            this.name = name;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++)
            people[i] = new Person(heights[i], names[i]);

        Arrays.sort(people, (a, b) -> b.height - a.height);

        for (int i = 0; i < n; i++)
            names[i] = people[i].name;

        return names;
    }
}