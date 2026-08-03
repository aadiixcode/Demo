class Solution {
    static class Pair{
        char ch;
        int index;
        Pair(char ch, int index){
            this.ch = ch;
            this.index = index;
        }
    }
    public String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.ch==b.ch){
                return b.index - a.index;
            }
            return a.ch - b.ch;
        });
        
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='*'){
                arr[pq.poll().index] = '*';
            }
            else {
                pq.add(new Pair(c,i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(arr[i]!='*'){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}