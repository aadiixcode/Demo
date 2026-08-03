class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for (int e : nums) {
            mp.put(e, mp.getOrDefault(e, 0) + 1);
        }

        List<Integer> l = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
            l.add(m.getKey());
        }
        Collections.sort(l);

        int index = 0;
        while (index < l.size()) {
            int e = l.get(index);
            if (mp.getOrDefault(e, 0) == 0) {
                index += 1;
                continue;
            }
            for (int i = 0; i < k; i++) {
                int currElement = e + i;
                if (mp.getOrDefault(currElement, 0) == 0) {
                    return false;
                }
                mp.put(currElement, mp.get(currElement) - 1);
            }

        }
        return true;
    }
}