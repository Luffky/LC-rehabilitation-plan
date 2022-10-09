import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String str = arr[i];
            if (map.containsKey(ch) && map2.containsKey(str)) {
                if (!map.get(ch).equals(str) || !map2.get(str).equals(ch)) {
                    return false;
                }
            } else if (!map.containsKey(ch) && !map2.containsKey(str)) {
                map.put(ch, str);
                map2.put(str, ch);
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

