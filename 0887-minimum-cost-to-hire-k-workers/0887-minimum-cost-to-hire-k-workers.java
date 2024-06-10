class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ans = Double.MAX_VALUE;
        int quality_sum=0;
        Pair<Double,Integer>[] workers = new Pair[quality.length];
        Queue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<quality.length;i++)
        workers[i]=new Pair<>((double)wage[i]/quality[i],quality[i]);

        Arrays.sort(workers,(a,b)->Double.compare(a.getKey(),b.getKey()));

        for(Pair<Double,Integer>worker:workers){
            double wagePerQuantity=worker.getKey();
            int q=worker.getValue();
            maxHeap.offer(q);
            quality_sum+=q;
            if(maxHeap.size()>k)
            quality_sum-=maxHeap.poll();
            if(maxHeap.size()==k)
            ans = Math.min(ans,quality_sum*wagePerQuantity);
        }
        return ans;
    }
}