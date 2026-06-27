class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int e: nums){
            mp.put(e,mp.getOrDefault(e,0)+1);
        }

        int ans = 0;
        for(int e: nums){
            int count=0;
            if(e==1){
               int freq=mp.get(1);
               if((freq & 1) == 0){
                count=freq-1;
               }else{
                count=freq;
               }
            }
            else {
                while(true){
                    if(mp.containsKey(e)){
                        if(mp.get(e)>=2) count+=2;
                        else if(mp.get(e)==1) {
                            count+=1;
                            break;
                        }
                    } 
                    else{
                        count-=1;
                        break; 
                    }
                    e=e*e;
                }
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}