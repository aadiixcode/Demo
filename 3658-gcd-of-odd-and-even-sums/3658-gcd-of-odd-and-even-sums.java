class Solution {
    static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }
        if (a == 0)
            return b;
        return a;
    }

    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n * n;
        int sumEven = n*(n+1);

        System.out.println(sumOdd);
        System.out.println(sumEven);
        return gcd(sumOdd, sumEven);
    }
}