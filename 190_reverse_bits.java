public class Solution {
    // you need treat n as an unsigned value
    int M1 = 0x55555555;
    int M2 = 0x33333333;
    int M3 = 0x0f0f0f0f;
    int M4 = 0x00ff00ff;
    public int reverseBits(int n) {
        n = (n >>> 1) & M1 | (n & M1) << 1;
        n = (n >>> 2) & M2 | (n & M2) << 2;
        n = (n >>> 4) & M3 | (n & M3) << 4;
        n = (n >>> 8) & M4 | (n & M4) << 8;
        return n >>> 16 | n << 16;
    }
}
