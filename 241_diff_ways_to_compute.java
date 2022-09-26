import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
class Solution {
    List<Integer> ret;
    public List<Integer> diffWaysToCompute(String expression) {
        ret = new LinkedList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        helper(map, expression);
        return map.get(expression);
    }

    public void helper(Map<String, List<Integer>> map, String expression) {
        if (isNumber(expression)) {
            map.put(expression, Arrays.asList(Integer.parseInt(expression)));
            return;
        }
        if (map.containsKey(expression)) {
            return;
        }
        map.put(expression, new LinkedList<>());
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                helper(map, expression.substring(0, i));
                helper(map, expression.substring(i + 1));
                for (int left : map.get(expression.substring(0, i))) {
                    for (int right : map.get(expression.substring(i + 1))) {
                        map.get(expression).add(cal(left, right, expression.charAt(i)));
                    }
                }
            }
        }
        return;
    }

    public boolean isNumber(String expression) {
        if (expression.length() > 2) {
            return false;
        }
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
    
    public int cal(int left, int right, char ope) {
        if (ope == '+') {
            return left + right;
        } else if (ope == '-') {
            return left - right;
        } else {
            return left * right;
        }
    }
}
// @lc code=end

