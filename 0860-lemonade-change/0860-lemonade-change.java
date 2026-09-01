class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveCount += 1;
            } else if (bill == 10) {
                tenCount += 1;
            }

            int moneyToReturn = bill - 5;
            if (moneyToReturn == 5) {
                if (fiveCount == 0) {
                    return false;
                }
                fiveCount -= 1;
            }
            if (moneyToReturn == 15) {
                if (fiveCount >= 1 && tenCount >= 1) {
                    fiveCount -= 1;
                    tenCount -= 1;
                }
                else if(fiveCount >= 3){
                    fiveCount -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}