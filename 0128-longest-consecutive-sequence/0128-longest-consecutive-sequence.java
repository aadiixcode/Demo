class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int e: nums){
            st.add(e);
        }

        int ans =0;
        for(int e: st){
            if(!st.contains(e-1)){
                int count = 1;
                while(st.contains(e+1)){
                    count+=1;
                    e+=1;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}