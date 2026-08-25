class Solution {
    public int numberOfBeams(String[] bank) {
        int totalLaserBeams = 0;
        int prev = 0;
        for (int i = 0; i < bank.length; i++) {
            int count = 0;
            for (char ch : bank[i].toCharArray()) {
                if (ch == '1') {
                    count += 1;
                }
            }
            if (count > 0) {
                if (prev > 0) {
                    totalLaserBeams += (prev * count);
                }
                prev = count;
            }

        }
        return totalLaserBeams;
    }
}