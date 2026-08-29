class Solution {
    int[] solveHalf(int i, int n, String s) {
        int xCount = 0, valueCount = 0;
        while (i < n && s.charAt(i) != '=') {
            boolean isNegative = false;
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (s.charAt(i) == '-') {
                    isNegative = true;
                }
                i += 1;
            }

            int value = 0;
            boolean flag = true;
            while (i < n && Character.isDigit(s.charAt(i))) {
                value = value * 10 + (s.charAt(i) - '0');
                flag = false;
                i += 1;
            }

            if (i < n && s.charAt(i) == 'x') {
                if (isNegative) {
                    xCount -= (value == 0 && flag) ? 1 : value;
                } else {
                    xCount += (value == 0 && flag) ? 1 : value;
                }
                i += 1;
            } else {
                if (isNegative) {
                    valueCount -= value;
                } else {
                    valueCount += value;
                }
            }
        }
        return new int[] { xCount, valueCount,i };
    }

    public String solveEquation(String s) {
        int n = s.length();

        int i = 0;
        int[] left = solveHalf(i, n, s);
        int leftX = left[0];
        int leftValue = left[1];

        i += left[2]+1;

        int[] right = solveHalf(i, n, s);
        int rightX = right[0];
        int rightValue = right[1];

        int x = leftX - rightX;
        int x_value = rightValue - leftValue;

        System.out.println(x + "," + x_value);

        if (x == 0 && x_value == 0) {
            return "Infinite solutions";
        }
        if (x == 0 && x_value != 0) {
            return "No solution";
        }

        x_value = x_value / x;
        return "x=" + x_value;
    }
}

// leftX = 0, leftValue = 0
// rightX = 0, rigthValue = 0