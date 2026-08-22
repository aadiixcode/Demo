class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char newChar = (nums[i].charAt(i) == '0') ? '1' : '0';
            sb.append(newChar);
        }
        return sb.toString();
    }
}