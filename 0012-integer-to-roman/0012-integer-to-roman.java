class Solution {
    public String intToRoman(int n) {
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };
        String[] romans = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (n == 0) {
                break;
            }

            int times = n / values[i];
            while (times > 0) {
                sb.append(romans[i]);
                times -= 1;
            }
            n = n % values[i];
        }
        return sb.toString();
    }
}