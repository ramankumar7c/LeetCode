class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int[] ans = new int[arr1.length];
        int index = 0;

        for(int num:arr1)
        count[num]++;

        for(int num:arr2){
            while(count[num]>0){
                ans[index++]=num;
                count[num]--;
            }
        }

        for(int num = 0;num<count.length;num++){
            while(count[num]>0){
                ans[index++]=num;
                count[num]--;
            }
        }
        return ans;
    }
}