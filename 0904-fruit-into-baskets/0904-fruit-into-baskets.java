class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 1;
        int basket1 = fruits[0], basket1Ind = 0;
        int basket2 = -1, basket2Ind = -1;
        int maxLen = 1;
        while (j < fruits.length) {
            if(fruits[j] != basket1 && fruits[j] != basket2){
                if(basket1Ind < basket2Ind){
                    i = basket1Ind + 1;
                    basket1 = fruits[j];
                }
                else{
                    i = basket2Ind + 1;
                    basket2 = fruits[j];
                }
            }
            if(fruits[j]==basket1){
                basket1Ind = j;
            }
            if(fruits[j]==basket2){
                basket2Ind = j;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j += 1;
        }
        return maxLen;
    }
}