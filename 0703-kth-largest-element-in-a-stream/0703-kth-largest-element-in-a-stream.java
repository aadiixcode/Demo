class KthLargest {
    List<Integer> arr;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        arr = new ArrayList<>();
        for(int e: nums){
            arr.add(e);
        }
    }
    
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr, (a,b) -> b-a);
        return arr.get(k-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */