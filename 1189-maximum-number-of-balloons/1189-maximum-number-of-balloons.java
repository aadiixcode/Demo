class Solution {
    public int maxNumberOfBalloons(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        mp.put('a',0);
        mp.put('b',0);
        mp.put('l',0);
        mp.put('o',0);
        mp.put('n',0);
        
        int count=0;
        for(char c: s.toCharArray()){
            if(c=='a'||c=='b'||c=='l'||c=='o'||c=='n'){
                mp.put(c,mp.get(c)+1);
            }
            if(mp.get('a')>=1 && mp.get('b')>=1 && mp.get('l')>=2 && mp.get('o')>=2 && mp.get('n')>=1){
                count+=1;
                mp.put('a',mp.get('a')-1);
                mp.put('b',mp.get('b')-1);
                mp.put('l',mp.get('l')-2);
                mp.put('o',mp.get('o')-2);
                mp.put('n',mp.get('n')-1);
            }
        }
        return count;
    }
}