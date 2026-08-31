class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        char[] charArr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int currentValue = charArr[i] - '0';
            if (currentValue == 9) {
                continue;
            }

            int maxValueInd = i;
            for (int j = i + 1; j < n; j++) {
                int rightValue = charArr[j] - '0';
                int maxTillNow = charArr[maxValueInd] - '0';
                if(rightValue >= maxTillNow && rightValue!=currentValue){
                    maxValueInd = j;
                }
            }
            if(maxValueInd > i){
                char temp = charArr[i];
                charArr[i] = charArr[maxValueInd];
                charArr[maxValueInd] = temp;
                return Integer.valueOf(new String(charArr));
            }
        }
        return num;
    }
}