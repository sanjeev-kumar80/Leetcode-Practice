import java.util.*;

class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(s, 0, dp);
    }

    public static int helper(String s, int start, int[] dp) {
        if (start == s.length()) {
            return -1;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        int min = Integer.MAX_VALUE;

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                int cost = 1 + helper(s, i + 1, dp);
                min = Math.min(min, cost);
            }
        }

        return dp[start] = min;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}