class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int e: nums){
            mp.put(e,mp.getOrDefault(e,0)+1);
        }

        int ans = 0;
        for(int e: nums){
            if(e==1){
               int freq=mp.get(1);
               if((freq & 1) == 0){
                ans = Math.max(ans,freq-1);
               }else{
                ans = Math.max(ans,freq);
               }
               continue;
            }

            int root = (int) Math.sqrt(e);
            if((root*root==e) && mp.containsKey(root) && mp.get(root)>=2){
                continue;
            }

            else {
                int count=0;
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
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}