import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            map[ch - 'a']--;
        }
        for (int cnt : map) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

