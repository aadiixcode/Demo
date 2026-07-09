class Solution {
    static boolean[] vis;
    static int n;

    static int gcd(int a, int b){
        while(a>0 && b>0){
            if(a>b) a = a % b;
            else b = b % a;
        }
        if(a==0) return b;
        return a;
    }

    static int helper(int[] nums,int opCount,Map<String,Integer> dp){
        String key = Arrays.toString(vis);
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int maxScore = 0;
        for(int i=0;i<n-1;i++){
            if(vis[i]) continue;
            for(int j=i+1;j<n;j++){
                if(vis[j]) continue;

                vis[i] = true;
                vis[j] = true;
                int score = (opCount * gcd(nums[i],nums[j])) + helper(nums,opCount+1,dp);
                vis[i] = false;
                vis[j] = false;
                maxScore = Math.max(maxScore,score);
            }
        }
        key = Arrays.toString(vis);
        dp.put(key,maxScore);
        return maxScore;
    }

    public int maxScore(int[] nums) {
        n = nums.length;
        vis = new boolean[n];
        Map<String,Integer> dp = new HashMap<>();
        return helper(nums,1,dp);
    }
}