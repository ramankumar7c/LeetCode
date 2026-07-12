class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer>sortedSet=new TreeSet<>();

        for(int num:arr)
        sortedSet.add(num);

        Map<Integer,Integer>map=new HashMap<>();
        int rank=1;

        for(int num:sortedSet)
        map.put(num,rank++);

        int[] res=new int[arr.length];

        for(int i=0;i<arr.length;i++)
        res[i]=map.get(arr[i]);

        return res;
    }
}