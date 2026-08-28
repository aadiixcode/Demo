class Solution {
    static int findGCD(int numerator, int denominator) {
        while (numerator > 0 && denominator > 0) {
            if (numerator > denominator) {
                numerator %= denominator;
            } else {
                denominator %= numerator;
            }
        }
        if (numerator == 0) {
            return denominator;
        }
        return numerator;
    }

    public String fractionAddition(String s) {
        int n = s.length();
        int numerator = 0;
        int denominator = 1;

        int i = 0;
        while (i < n) {
            boolean isNegative = false;
            int currentNumerator = 0;
            int currentDenominator = 0;
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (s.charAt(i) == '-') {
                    isNegative = true;
                }
                i += 1;
            }

            while (i < n && Character.isDigit(s.charAt(i))) {
                currentNumerator = (currentNumerator * 10) + (s.charAt(i) - '0');
                i += 1;
            }
            i += 1;

            while (i < n && Character.isDigit(s.charAt(i))) {
                currentDenominator = (currentDenominator * 10) + (s.charAt(i) - '0');
                i += 1;
            }

            if (isNegative) {
                currentNumerator = -currentNumerator;
            }
            System.out.println(currentNumerator);
            System.out.println(currentDenominator);
            numerator = (numerator * currentDenominator) + (currentNumerator * denominator);
            denominator = denominator * currentDenominator;
            // System.out.println(numerator);
            // System.out.println(denominator);
        }

        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;

        return String.valueOf(numerator) + "/" + String.valueOf(denominator);
    }
}

/*

-1 1


*/