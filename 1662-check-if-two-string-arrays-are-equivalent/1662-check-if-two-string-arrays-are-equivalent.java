class Solution {
    public boolean arrayStringsAreEqual(String[] arr1, String[] arr2) {
        int i = 0, j = 0;
        int wi = 0, wj = 0;

        while (i < arr1.length && j < arr2.length) {
            if(arr1[i].charAt(wi) != arr2[j].charAt(wj)){
                return false;
            }
            wi += 1;
            wj += 1;

            if (wi == arr1[i].length()) {
                wi = 0;
                i += 1;
            }
            if (wj == arr2[j].length()) {
                wj = 0;
                j += 1;
            }
        }
        if(i==arr1.length && j==arr2.length){
            return true;
        }
        return false;
    }
}