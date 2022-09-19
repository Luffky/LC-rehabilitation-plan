/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (ax1 > bx1) {
            int tmp1 = ax1;
            ax1 = bx1;
            bx1 = tmp1;
            int tmp2 = ax2;
            ax2 = bx2;
            bx2 = tmp2;
            int tmp3 = ay1;
            ay1 = by1;
            by1 = tmp3;
            int tmp4 = ay2;
            ay2 = by2;
            by2 = tmp4;
        }
        int area = (by2 - by1) * (bx2 - bx1) + (ay2 - ay1) * (ax2 - ax1);
        //不重叠的情况
        if (bx1 >= ax2 || by2 <= ay1 || by1 >= ay2) {
            return area;
        }
        //互不包含的情况
        return area - (Math.min(by2, ay2) - Math.max(by1, ay1)) * (Math.min(bx2, ax2) - Math.max(bx1, ax1));
    }
}
// @lc code=end

