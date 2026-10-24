
class Solution {
    public void help(int arr[][], int days[], String sa, String la) {

        int sr = (sa.charAt(0) - '0') * 10 + sa.charAt(1) - '0';
        int sc = (sa.charAt(3) - '0') * 10 + sa.charAt(4) - '0';

        int er = (la.charAt(0) - '0') * 10 + la.charAt(1) - '0';
        int ec = (la.charAt(3) - '0') * 10 + la.charAt(4) - '0';

        if (sr == er) {
            for (int i = sc; i <= ec; i++) {
                arr[sr][i]++;
            }
        } else {

            // Starting month
            for (int i = sc; i <= days[sr - 1]; i++) {
                arr[sr][i]++;
            }

            // Ending month
            for (int i = 1; i <= ec; i++) {
                arr[er][i]++;
            }

            // Intermediate months
            for (int i = sr + 1; i < er; i++) {
                for (int j = 1; j <= days[i - 1]; j++) {
                    arr[i][j]++;
                }
            }
        }
    }

    public int countDaysTogether(String sa, String la, String sb, String lb) {

        int days[] = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int arr[][] = new int[13][32];
        int arr2[][] = new int[13][32];

        help(arr, days, sa, la);
        help(arr2, days, sb, lb);

        int ans = 0;

        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 31; j++) {
                if (arr[i][j] == 1 && arr2[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
