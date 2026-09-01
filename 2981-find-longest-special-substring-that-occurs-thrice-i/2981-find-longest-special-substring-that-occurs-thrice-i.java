class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> mp = new HashMap<>();
        int n = s.length();
        int maxLength = -1;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));
                String substring = sb.toString();
                boolean isEqual = true;
                for (int pos = 1; pos < substring.length(); pos++) {
                    if (substring.charAt(pos) != substring.charAt(pos - 1)) {
                        isEqual = false;
                        break;
                    }
                }

                if(!isEqual){
                    break;
                }

                if (isEqual) {
                    mp.put(substring, mp.getOrDefault(substring, 0) + 1);
                    if(mp.get(substring) >= 3){
                        maxLength = Math.max(maxLength,substring.length());
                    }
                }
            }
        }

        System.out.println(mp);
        return maxLength;
    }
}