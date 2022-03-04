class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            n = get(n);
            if (set.contains(n)) {
                return false;
            } else if (n == 1) {
                return true;
            }
            set.add(n);
        } 
    }

    public int get(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            sum += temp * temp;
        }
        return sum;
    }
}
