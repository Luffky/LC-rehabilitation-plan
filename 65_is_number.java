class Solution {
    public boolean isNumber(String s) {
        if (s.indexOf(".") != s.lastIndexOf(".")) {
            return false;
        }
        String[] a = s.split("\\.");
        if (a.length == 2 && a[0].length() == 0){
            String[] b = new String[]{a[1]};
            a = b;
        }
        if (a.length > 2) { //有多于一个.
            return false;
        } else if (a.length == 2) { //有一个.，且前后都有数字
            if (!isZhengshu(a[0], true, true)) { //前边的数字只能为整数不能带e，可以为空，可以带符号
                return false;
            }
            return isZhengshuWithe(a[1], true, false); //可能带e
        } else if (a.length == 1) { //没有.，或者有.，但前后只有一边有数字
            if (s.charAt(0) == '.') { //后边有数字
                return isZhengshuWithe(a[0], false, false); //可能带e
            } else if (s.charAt(s.length() - 1) == '.') { //前边有数字
                return isZhengshu(a[0], true, false); //前边有数字只能为一个整数不能带e，不可以为空，可以带符号
            } else { //没有.，是一个整数
                return isZhengshuWithe(a[0], false, true);//可能带e
            }
        } else {
            return false;
        }
    }

    public boolean isZhengshu(String s, boolean withPlus, boolean canEmpty) {
        if (s.length() == 0) {
            return canEmpty;
        }
        char[] ch = s.toCharArray();
        boolean hasPlus = false;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '+' || ch[i] == '-') {
                if (i != 0) {
                    return false;
                } else if (!withPlus) {
                    return false;
                } else {
                    hasPlus = true;
                }
            } else if (ch[i] >= '0' && ch[i] <= '9') {
                hasPlus = false;
            } else {
                return false;
            }
        }
        return !hasPlus || canEmpty;
    }

    public boolean isZhengshuWithe(String s, boolean canEmpty, boolean withPlus) {
        int id1 = s.indexOf('e');
        int id2 = s.indexOf('E');
        if (id1 != -1) { //有一个以上的e
            if (!isZhengshu(s.substring(0, id1), withPlus, canEmpty)) { //e前面必须为无符号整数，可以为空
                return false;
            } 
            if (!isZhengshu(s.substring(id1 + 1, s.length()), true, false)) { //e后面可以带符号，但不能为空
                return false;
            }
            return true;
        } else if (id2 != -1) { //有一个以上的E
            if (!isZhengshu(s.substring(0, id2), withPlus, canEmpty)) { //同上
                return false;
            } 
            if (!isZhengshu(s.substring(id2 + 1, s.length()), true, false)) {
                return false;
            }
            return true;
        } else { //不带e和E
            return isZhengshu(s, withPlus, canEmpty); //必须为一个无符号整数，是否为空视传参而定
        }
    }
}
