import java.util.*;
class Solution {
    String s;
    int[][][] dp;
    int n;
    String[] arr;

    public int func(int ind, int tight, int lz){
        if (ind == n) return 1;

        if (dp[ind][tight][lz] != -1) return dp[ind][tight][lz];

        int lim = ((tight == 1) ? (s.charAt(ind) - '0') : 10);
        int ans = 0;

        for (int i = 0; i < arr.length; i++){
            int d = Integer.parseInt(arr[i]);

            if (d > lim) break;
            int ntight = (tight == 1 && d == lim) ? 1 : 0;
            ans += func(ind + 1, ntight, 0);
        }
         if(lz == 1)
            ans += func(ind + 1, 0, 1);
        return dp[ind][tight][lz] = ans;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = String.valueOf(n); // FIXED
        this.n = s.length();
        arr = digits;

        dp = new int[this.n][2][2];

        for (int[][] a : dp) {
            for(int[] b : a) {
               Arrays.fill(b, -1);
            }
        }

        return func(0, 1, 1)-1;
    }
}