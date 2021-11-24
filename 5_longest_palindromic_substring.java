class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int begin = 0;
        int end = -1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (i == 0) {
                    dp[j][j + i] = true;
                } else if (i == 1) {
                    if (s.charAt(j) == s.charAt(j + i)) {
                        dp[j][j + i] = true;
                    } 
                } else {
                    if (s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1]) {
                        dp[j][j + i] = true;
                    }
                }
                if (dp[j][j + i] && i + 1 > end - begin + 1) {
                    begin = j;
                    end = j + i;
                }
            }
        }
        return s.substring(begin, end + 1);
    }
}
