class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int[] xors = new int [n+1];
        int prefix = 0;

        for(int i=0;i<n;i++){
            prefix ^= arr[i];
            xors[i+1] = prefix;
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<j;i++){
                int xors_i = xors[j] ^ xors[i];
                for(int k=j;k<n;k++){
                    int xors_k = xors[k+1]^xors[j];
                    if(xors_i == xors_k)
                    ans++;
                }
            }
        }
        return ans;
    }
}