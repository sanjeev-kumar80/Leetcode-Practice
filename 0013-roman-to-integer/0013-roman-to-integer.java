class Solution {
    private int value(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return 0;
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));
            if (i + 1 < s.length() && curr < value(s.charAt(i + 1))) {
                result -= curr;
            } else {
                result += curr;
            }
        }
        return result;
    }
}