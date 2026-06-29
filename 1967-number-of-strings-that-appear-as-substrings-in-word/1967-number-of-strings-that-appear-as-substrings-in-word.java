class Solution {
    public int numOfStrings(String[] patterns, String word) {
        Map<String,Integer> mp = new HashMap<>();
        for(String s:patterns){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }

        int ans=0;
        for(int i=0;i<word.length();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<word.length();j++){
                sb.append(word.charAt(j));
                String s = sb.toString();
                if(mp.containsKey(s)){
                    ans += mp.get(s);
                    mp.remove(s);
                }
            }
        }
        return ans;
    }
}