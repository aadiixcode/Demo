class Pair{
    int count;
    char ch;
    Pair(int count,char ch){
        this.count=count;
        this.ch=ch;
    }
}
class Solution {

    public String frequencySort(String s) {
        int[] freq = new int[62];
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                freq[ch - 'a'] += 1;
            } else if (Character.isUpperCase(ch)) {
                freq[ch - 'A' + 26] += 1;
            } else {
                freq[ch - '0' + 52] += 1;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
        for(int i=0;i<62;i++){
            if(freq[i]>0){
                char ch;
                if(i<26){
                    ch = (char)('a'+i);
                }
                else if(i>=26 && i<52){
                    ch = (char) ('A'+i-26);
                }
                else{
                    ch = (char)('0'+i-52);
                }
                pq.add(new Pair(freq[i],ch));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int f = p.count;
            char c = p.ch;

            while(f!=0){
                sb.append(c);
                f -= 1;
            }
        } 
        return sb.toString();

    }
}