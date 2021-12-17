class Solution {
    public String getPermutation(int n, int k) {
        k--;
        int[] arr = new int[]{1,1,1,1,1,1,1,1,1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            int total = getN(n - i - 1);
            int num = k / total;
            int targetRank = getNth(arr, num + 1);
            arr[targetRank - 1] = 0;
            sb.append((char) (targetRank + '0'));
            k -= total * num;
        }
        int targetRank = getNth(arr, 1);
        sb.append((char) (targetRank + '0'));
        return sb.toString();
    }

    public int getN(int n) {
        int result = 1;
        while (n > 0) {
            result *= n--;
        }
        return result;
    }

    public int getNth(int[] arr, int n) {
        int rank = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                rank++;
            }
            if (rank == n) {
                return i + 1;
            }
        }
        return 0;
    }
}
