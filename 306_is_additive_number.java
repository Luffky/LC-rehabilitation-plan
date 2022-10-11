/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        //确定第一个数
        for (int i = 0; i < num.length() / 2; i++) {
            //不能有前导0
            if (i != 0 && num.charAt(0) == '0') {
                return false;
            }
            //确定第二个数
            for (int j = i + 1; j < num.length(); j++) {
                //不能有前导0
                if (j != i + 1 && num.charAt(i + 1) == '0') {
                    break;
                }
                //如果起始两个数字中任何一个位数大于剩余位数则不可能有解
                if (num.length() - j - 1 < Math.max(i + 1, j - i)) {
                    break;
                }
                Long a = Long.valueOf(num.substring(0, i + 1));
                Long b = Long.valueOf(num.substring(i + 1, j + 1));

                //确定了第一和第二个数，开始在剩余的数字里确认是否满足累加数
                Long c = a + b;
                String tmp = num.substring(j + 1);
                System.out.println("a: "+ a + ", b: " + b + ", c: " + c + ", tmp: " + tmp);
                while (tmp.length() != 0 && tmp.startsWith(String.valueOf(c))) {
                    a = b;
                    b = c;
                    c = a + b;
                    tmp = tmp.substring(String.valueOf(b).length());
                    System.out.println("a: "+ a + ", b: " + b + ", c: " + c + ", tmp: " + tmp);
                }
                if (tmp.length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

