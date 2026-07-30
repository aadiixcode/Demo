class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> arr = new ArrayList<>();
        for (int e : stones) {
            arr.add(e);
        }
        Collections.sort(arr);
        while(arr.size()>1){
            int a = arr.removeLast();
            int b = arr.removeLast();
            if(a != b){
                arr.add(a-b);
            }
            Collections.sort(arr);
        }
        if(arr.size()==1){
            return arr.get(0);
        }
        return 0;
    }
}