class Solution {
    static class Pair{
        int oldValue,newValue;
        Pair(int oldValue,int newValue){
            this.oldValue = oldValue;
            this.newValue = newValue;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] map = new int[10];
        for (int i = 0; i < mapping.length; i++) {
            map[i] = mapping[i];
        }

        List<Pair> mappedValue = new ArrayList<>();
        for(int num: nums){
            String value = String.valueOf(num);
            int newValue = 0;
            for(char digit: value.toCharArray()){
                newValue = newValue * 10 + map[digit-'0'];
            }
            mappedValue.add(new Pair(num,newValue));
        }
        Collections.sort(mappedValue,(a,b)->{
            return a.newValue - b.newValue;
        });


        int[] answer = new int[nums.length];
        int index = 0;
        for(Pair p: mappedValue){
            answer[index++] = p.oldValue;
        }
        return answer;
    }
}

/*



*/