class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> ans = new ArrayList<>();

        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();

        for (int len = minLen; len <= maxLen; len++) {

            for (int start = 0; start + len <= 9; start++) {

                String s = digits.substring(start, start + len);
                int num = Integer.parseInt(s);

                if (num >= low && num <= high)
                    ans.add(num);
            }
        }

        return ans;
    }
}