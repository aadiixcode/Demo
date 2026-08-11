class Solution {
    public String reorderSpaces(String s) {
        int n = s.length();
        int i = 0;
        int totalSpaces = 0;
        List<String> temp = new ArrayList<>();
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') {
                i += 1;
                totalSpaces += 1;
            }
            if(i>=n){
                break;
            }
            StringBuilder sb = new StringBuilder();
            while (i < n && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i += 1;
            }
            temp.add(sb.toString());
        }

        // System.out.println(totalSpaces);
        // System.out.println(temp);

        int totalWords = temp.size();
        int evenlySpaces =  (totalWords - 1)==0 ? totalSpaces : totalSpaces / (totalWords - 1);
        int extraSpaces = (totalWords - 1)==0 ? totalSpaces : totalSpaces % (totalWords - 1);
        // System.out.println(evenlySpaces);
        // System.out.println(extraSpaces);

        StringBuilder ans = new StringBuilder();
        for (int j = 0; j < totalWords; j++) {
            ans.append(temp.get(j));
            if (j != totalWords - 1) {
                ans.append(" ".repeat(evenlySpaces));
            } 
            if (j == totalWords - 1) {
                ans.append(" ".repeat(extraSpaces));
            }
        }
        return ans.toString();
    }
}