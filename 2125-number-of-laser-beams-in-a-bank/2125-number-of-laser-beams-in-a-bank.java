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
        int i = 0;
        while (i < m) {
            int c1 = securityCount[i];
            i += 1;
            while (i < m && securityCount[i] == 0) {
                i += 1;
            }
            if (i < m) {
                totalLaserBeams += (c1 * securityCount[i]);
            }
        }
        return totalLaserBeams;
    }
}