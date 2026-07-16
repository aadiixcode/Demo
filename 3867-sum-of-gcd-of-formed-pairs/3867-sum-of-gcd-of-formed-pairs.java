class Solution {
    static int gcd(int a,int b){
        while(a>0 && b>0){
            if(a>b) a=a%b;
            else b=b%a;
        }
        if(a==0) return b;
        return a;
    } 
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] prefixGcd = new int[n];

        int mx = nums[0];
        for(int i=0;i<n;i++){
            mx = Math.max(mx,nums[i]);
            prefixGcd[i] = gcd(nums[i],mx);
        }
        Arrays.sort(prefixGcd);

        long sum = 0;
        int i=0,j=n-1;
        while(i<j){
            sum += gcd(prefixGcd[i],prefixGcd[j]);
            i+=1;
            j-=1;
        }
        return sum;
    }
}