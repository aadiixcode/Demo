class Solution {
    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();
        if (k > 1) {
            Arrays.sort(arr);
            return new String(arr);
        }

        String ans = new String(arr);
        int n = s.length();
        for(int i=1;i<=n-1;i++){
            String temp = s.substring(i) + s.substring(0,i);
            if(temp.compareTo(ans) < 0){
                ans = temp;
            }
        }
        return ans;
    }
}