/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    // public int nthUglyNumber(int n) {
    //     PriorityQueue<Long> pq = new PriorityQueue<>();    
    //     Set<Long> set = new HashSet<>();
    //     int cnt = 0;
    //     pq.add((long) 1);
    //     long cur = 0;
    //     while (cnt != n) {
    //         cur = pq.poll();
    //         cnt++;
    //         if (!set.contains(cur * 2)) {
    //             pq.add(cur * 2);
    //             set.add(cur * 2);
    //         }
    //         if (!set.contains(cur * 3)) {
    //             pq.add(cur * 3);
    //             set.add(cur * 3);
    //         }
    //         if (!set.contains(cur * 5)) {
    //             pq.add(cur * 5);
    //             set.add(cur * 5);
    //         }
    //     }
    //     return (int) cur;
    // }
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p1 = 1, p2 = 1, p3 = 1;
        for (int i = 2; i <= n; i++) {
            if (dp[p1] * 2 <= dp[p2] * 3 && dp[p1] * 2 <= dp[p3] * 5) {
                dp[i] = dp[p1] * 2;
                p1++;
            } else if (dp[p2] * 3 <= dp[p1] * 2 && dp[p2] * 3 <= dp[p3] * 5) {
                dp[i] = dp[p2] * 3;
                p2++;
            } else {
                dp[i] = dp[p3] * 5;
                p3++;
            }
            if (dp[i] == dp[i - 1]) {
                i--;
            }
        }
        return dp[n];
    }
}
// @lc code=end

