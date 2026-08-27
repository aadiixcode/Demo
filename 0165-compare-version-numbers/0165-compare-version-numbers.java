class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int i = 0, j = 0;
        while (i < arr1.length || j < arr2.length) {
            int val1 = 0;
            if (i < arr1.length) {
                val1 = Integer.valueOf(arr1[i]);
            }
            int val2 = 0;
            if (j < arr2.length) {
                val2 = Integer.valueOf(arr2[j]);
            }

            if (val1 < val2) {
                return -1;
            }
            if (val1 > val2) {
                return 1;
            }

            i += 1;
            j += 1;
        }
        return 0;
    }
}