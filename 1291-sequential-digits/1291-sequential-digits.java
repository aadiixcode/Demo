class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=8;i++){
            q.add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int num = q.poll();
            if(num>=low && num<=high){
                ans.add(num);
            }
            int lastDigit = num % 10;
            if(lastDigit+1 <=9 ){
                q.add((num * 10) + lastDigit+1);
            }
        }
        return ans;
    }
}