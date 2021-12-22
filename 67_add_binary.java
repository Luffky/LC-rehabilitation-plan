class Solution {
    public String addBinary(String a, String b) {
        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();
        int carry = 0;
        char[] result = new char[Math.max(cha.length, chb.length) + 1];
        int i = cha.length - 1;
        int j = chb.length - 1;
        int k = 0;
        while(i >= 0 && j >= 0) {
            int sum = (cha[i--] - '0') + (chb[j--] - '0') + carry;
            if (sum == 3) {
                carry = 1;
                result[k] = '1';
            } else if (sum == 2) {
                carry = 1;
                result[k] = '0';
            } else if (sum == 1) {
                carry = 0;
                result[k] = '1';
            } else {
                carry = 0;
                result[k] = '0';
            }
            k++;
        }
        if (j >= 0) {
            cha = chb;
            i = j;
        }
        while (i >= 0) {
            int sum = (cha[i] - '0') + carry;
            if (sum == 2) {
                carry = 1;
                result[k] = '0';
            } else if (sum == 1) {
                carry = 0;
                result[k] = '1';
            } else {
                carry = 0;
                result[k] = '0';
            }
            k++;
            i--;
        }
        if (carry > 0) {
            result[k++] = '1';
        }
        StringBuilder sb = new StringBuilder();
        for (int l = k - 1; l >= 0; l--) {
            sb.append(result[l]);
        }
        return sb.toString();
    }
}
