class Solution {
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int seatCount = 0;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                temp.add(i);
                seatCount += 1;
            }
        }
        if (seatCount == 0 || seatCount % 2 != 0) {
            return 0;
        }

        // System.out.println(temp);

        int totalWays = 1;
        for (int i = 2; i < temp.size(); i += 2) {
            if (i + 1 < temp.size()) {
                int size = temp.get(i) - temp.get(i - 1);
                totalWays = (int) ((1L * totalWays * size) % 1000000007);
            }
        }
        return totalWays;
    }
}