class Solution {
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int seatCount = 0;
        long totalWays = 1;
        int first = -1, second = -1;
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                if(first == -1){
                    first = i;
                }
                else if(second == -1){
                    second = i;
                }
                else if(first != -1 && second != -1){
                    totalWays = (totalWays*(i-second)) % 1000000007;
                    first = i;
                    second = -1;
                }
                seatCount += 1;
            }
        }
        if (seatCount == 0 || seatCount % 2 != 0) {
            return 0;
        }

        return (int)totalWays;
    }
}