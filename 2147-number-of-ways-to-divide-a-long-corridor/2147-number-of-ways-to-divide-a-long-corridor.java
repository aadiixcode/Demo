class Solution {
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                temp.add(i);
            }
        }
        if (temp.size() == 0 || temp.size() % 2 != 0) {
            return 0;
        }

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