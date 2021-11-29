class Solution {
    public String intToRoman(int num) {
        int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] strs = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        for (int i = 12; i >= 0; i--) {
            int n = num / nums[i];
            while (n > 0) {
                sb.append(strs[i]);
                n--;
            }
            num = num % nums[i];
        }
        return sb.toString();
    }
}
