class Solution {
    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();
        if (k > 1) {
            Arrays.sort(arr);
            return new String(arr);
        }

        String ans = new String(arr);
        String temp = s + s;
        int n = s.length();
        for(int i=1;i<=n-1;i++){
            String t1 = temp.substring(i,n+i);
            if(t1.compareTo(ans) < 0){
                ans = t1;
            }
        }
        return ans;
    }
}