class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int[] securityCount = new int[m];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (char ch : bank[i].toCharArray()) {
                if (ch == '1') {
                    count += 1;
                }
            }
            securityCount[i] = count;
        }

        int totalLaserBeams = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (securityCount[j] > 0) {
                    totalLaserBeams += (securityCount[i] * securityCount[j]);
                    break;
                }
            }

        }
        return totalLaserBeams;
    }
}