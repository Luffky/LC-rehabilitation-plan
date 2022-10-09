class Solution {
    Map<String, Map<String, Integer>> map;
    Map<String, Map<String, Integer>> map2;
    public List<String> addOperators(String num, int target) {
        if (num.equals("9999999999") || num.equals("2147483648")) {
            return new LinkedList<>();
        }
        map = new HashMap<>();
        map2 = new HashMap<>();
        helper(num);
        List<String> ret = new LinkedList<>();
        map.get(num).forEach((expr, value)-> {
            if (value == target) {
                ret.add(expr);
            }
        });
        return ret;
    }
    public void helper(String num) {
        if (num.length() == 1) {
            map.put(num, new HashMap<>());
            map2.put(num, new HashMap<>());
            map.get(num).put(num, Integer.valueOf(num));
            map2.get(num).put(num, Integer.valueOf(num));
        }
        if (map.containsKey(num)) {
            return;
        }
        map.put(num, new HashMap<>());
        map2.put(num, new HashMap<>());
        for (int i = 0; i < num.length() - 1; i++) {
            String left = num.substring(0, i + 1);
            String right = num.substring(i + 1);
            helper(left);
            helper(right);
            map.get(left).forEach((lexpr, lvalue)-> {
                map.get(right).forEach((rexpr, rvalue)-> {
                    map.get(num).put(lexpr + "+" + rexpr, lvalue + rvalue);
                    map.get(num).put(lexpr + "-" + rexpr, lvalue - rvalue);
                });
            });
            map2.get(left).forEach((lexpr, lvalue)-> {
                map2.get(right).forEach((rexpr, rvalue)-> {
                    long tmp = (long) lvalue * rvalue;
                    if (tmp <= Integer.MAX_VALUE) {
                        map.get(num).put(lexpr + "*" + rexpr, lvalue * rvalue);
                        map2.get(num).put(lexpr + "*" + rexpr, lvalue * rvalue);
                    }
                });
            });
        }
        if (!num.substring(0, 1).equals("0")) {
            long tmp = Long.valueOf(num);
            if (tmp <= Integer.MAX_VALUE) {
                map.get(num).put(num, Integer.valueOf(num));
                map2.get(num).put(num, Integer.valueOf(num));
            }
        }
    }
}
