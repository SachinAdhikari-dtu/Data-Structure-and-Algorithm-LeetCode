class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (n == 0) return true;

            if (arr[i] == 0) {
                boolean leftOk = (i == 0) || (arr[i - 1] == 0);
                boolean rightOk = (i == len - 1) || (arr[i + 1] == 0);
                if (leftOk && rightOk) {
                    arr[i] = 1;
                    n--;
                }
            }
        }
        return n == 0;
    }
}