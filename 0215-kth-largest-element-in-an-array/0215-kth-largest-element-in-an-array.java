class Solution {

    int quickSort(int low, int high, int[] arr) {
        int i = low, j = high;
        int pivot = arr[low];
        while (i <= j) {
            if (arr[i] < pivot && arr[j] > pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i += 1;
                j -= 1;
            }
            if (arr[i] >= pivot) {
                i += 1;
            }
            if (arr[j] <= pivot) {
                j -= 1;
            }
        }

        if (j != low) {
            int temp = arr[j];
            arr[j] = arr[low];
            arr[low] = temp;
        }
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;

        int pivotInd = 0;
        while (low < high) {
            pivotInd = quickSort(low, high, nums);
            if (pivotInd == k - 1) {
                break;
            } else if (k - 1 < pivotInd) {
                high = pivotInd - 1;
            } else if (k - 1 > pivotInd) {
                low = pivotInd + 1;
            }
        }
        if (low == high) {
            pivotInd = low;
        }
        return nums[pivotInd];
    }
}