class Solution {
    static int[] findLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int i = 0, j = 1;
        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[j] = i + 1;
                i += 1;
                j += 1;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j += 1;
                } else {
                    i = lps[i - 1];
                }
            }
        }
        return lps;
    }

    static List<Integer> allOccurenceIndices(int[] lps, String s, String pattern) {
        List<Integer> occurences = new ArrayList<>();
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == pattern.charAt(j)) {
                i += 1;
                j += 1;
                if (j == pattern.length()) {
                    occurences.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j == 0) {
                    i += 1;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        return occurences;
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int[] lps1 = findLPS(a);
        int[] lps2 = findLPS(b);

        List<Integer> aOccurences = allOccurenceIndices(lps1, s, a);
        List<Integer> bOccurences = allOccurenceIndices(lps2, s, b);

        List<Integer> ans = new ArrayList<>();
        for (int e : aOccurences) {
            int low = 0, high = bOccurences.size() - 1;
            int left = e - k;
            int right = e + k;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (bOccurences.get(mid) >= left && bOccurences.get(mid) <= right) {
                    ans.add(e);
                    break;
                } else if (bOccurences.get(mid) < left) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return ans;
    }
}