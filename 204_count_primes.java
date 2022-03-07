class Solution {
    public int countPrimes(int n) {
        int count = 0;
        int[] primesArr = new int[n];
        for (int i = 2; i < n; i++) {
            if (primesArr[i] == 0) {
                count++;
                for (long j = (long) i * i; j < n; j += i) {
                    primesArr[(int)j] = 1;
                }
            } else {
                continue;
            }
        }
        return count;
    }
}
