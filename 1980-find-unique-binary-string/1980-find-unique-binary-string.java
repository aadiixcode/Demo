class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        Set<Integer> st = new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(Integer.parseInt(nums[i],2));
        }

        for(int i=0;i<=n;i++){
            if(!st.contains(i)){
                String binary = String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0');
        
                return binary.substring(16-n);
            }
        }
        return " ";
    }
}