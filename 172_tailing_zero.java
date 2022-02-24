class Solution {
    public int trailingZeroes(int n) {
        int num = 5;
        int total = 0;
        while (num <= n) {
            total += n / num;
            num *= 5;
        }
        return total;
    }
}
