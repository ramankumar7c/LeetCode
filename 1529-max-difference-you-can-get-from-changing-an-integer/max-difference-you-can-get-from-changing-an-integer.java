class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        int maxNum = getMax(s);
        int minNum = getMin(s);
        return maxNum - minNum;
    }

    private int getMax(String s) {
        char[] arr = s.toCharArray();
        char target = '9';

        for (int i = 0; i < arr.length; i++)
            if (arr[i] != '9') {
                target = arr[i];
                break;
            }

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                arr[i] = '9';

        return Integer.parseInt(new String(arr));
    }

    private int getMin(String s) {
        char[] arr = s.toCharArray();
        char target = '0';
        if (arr[0] != '1') {
            target = arr[0];
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == target)
                    arr[i] = '1';
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != '0' && arr[i] != '1') {
                    target = arr[i];
                    break;
                }
            }
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == target)
                    arr[i] = '0';
        }
        return Integer.parseInt(new String(arr));
    }
}