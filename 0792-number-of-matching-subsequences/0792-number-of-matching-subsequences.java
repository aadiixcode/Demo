class Solution {

    int upperBound(int prevInd, List<Integer> indices) {
        int low = 0, high = indices.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (indices.get(mid) <= prevInd) {
                low = mid + 1;
            }
            else if(indices.get(mid) > prevInd){
                ans = indices.get(mid);
                high = mid-1;
            }
        }
        return ans;
    }

    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> mp = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            List<Integer> temp;
            if (!mp.containsKey(ch)) {
                temp = new ArrayList<>();
            } else {
                temp = mp.get(ch);
            }
            temp.add(i);
            mp.put(ch, temp);
        }


        int count = 0;
        for (String word : words) {
            int prevInd = -1;
            int i = 0, n = word.length();
            while (i < n) {
                char ch = word.charAt(i);
                if (!mp.containsKey(ch)) {
                    break;
                }
                List<Integer> indices = mp.get(ch);
                int nextInd = upperBound(prevInd,indices);
                if(nextInd == -1){
                    break;
                }
                else {
                    prevInd = nextInd;
                }
                i += 1;
            }
            if (i == n) {
                count += 1;
            }
        }
        return count;
    }
}