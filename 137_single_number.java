class Solution {
    int[] arr = new int[32];
    public int singleNumber(int[] nums) {
        for (int num : nums) {
            process(num, arr);
        }
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            int n = arr[i];
            result |= n % 3 == 0 ? 0 : 1;
        }
        return result;
    }

    public void process(int num, int[] arr) {
        int i = 0;
        while(num != 0) {
            arr[i++] += num & 1;
            num >>>= 1;
        }
    }
}
