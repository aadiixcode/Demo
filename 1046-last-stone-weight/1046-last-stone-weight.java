class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> arr = new ArrayList<>();
        for (int e : stones) {
            arr.add(e);
        }
        Collections.sort(arr,(a,b) -> b-a);
        while(arr.size()>1){
            int x = arr.removeFirst();
            int y = arr.removeFirst();
            if(x != y){
                arr.add(x-y);
            }
            Collections.sort(arr, (a,b) -> b-a);
        }
        if(arr.size()==1){
            return arr.get(0);
        }
        return 0;
    }
}