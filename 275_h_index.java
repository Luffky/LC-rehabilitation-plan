/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int s = 0;
        int e = citations.length - 1;
        int n = citations.length;
        int max = 0;
        while (s <= e) {
            int m = (s + e) / 2;
            if (n - m >= citations[m]) {
                max = Math.max(max, citations[m]);
                s = m + 1;
            } else {
                max = Math.max(max, n - m);
                e = m - 1;
            }
        }
        return max;
    }
}
// @lc code=end

