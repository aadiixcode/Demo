class Solution {

    String fillWord(String[] words, int start, int end, int spaceBetweenWords, int extraSpaceBetweenWords, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            if(i != end-1){
                sb.append(" ".repeat(spaceBetweenWords));
                if(extraSpaceBetweenWords>0){
                    sb.append(" ");
                    extraSpaceBetweenWords -= 1;
                }
            }
        }
        while(sb.length()<maxWidth){
            sb.append(" ");
        }
        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        int n = words.length;
        int i = 0;
        List<String> answer = new ArrayList<>();
        while (i < n) {
            int charCount = words[i].length();
            int spaceCount = 0;
            int j = i + 1;
            while (j < n && charCount + words[j].length() + 1 + spaceCount <= maxWidth) {
                spaceCount += 1;
                charCount += words[j].length();
                j += 1;
            }
            int extraSpaces = maxWidth - charCount;
            int spaceBetweenWords = (spaceCount == 0) ? 0 : extraSpaces / spaceCount;
            int extraSpaceBetweenWords = (spaceCount == 0) ? 0 : extraSpaces % spaceCount;

            if (j == n) {
                spaceBetweenWords = 1;
                extraSpaceBetweenWords = 0;
            }

            String line = fillWord(words, i, j, spaceBetweenWords, extraSpaceBetweenWords,maxWidth);
            answer.add(line);
            i = j;
        }
        return answer;
    }
}