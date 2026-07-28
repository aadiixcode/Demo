class Pair{
    int aliceValue;
    int bobValue;
    int totalProfit;
    Pair(int aliceValue,int bobValue, int totalProfit){
        this.aliceValue = aliceValue;
        this.bobValue = bobValue;
        this.totalProfit = totalProfit;
    }
}

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            if(a.totalProfit==b.totalProfit){
                return b.aliceValue - a.aliceValue;
            }
            return b.totalProfit - a.totalProfit;
        });
        
        for(int i=0;i<n;i++){
            int totalProfit = aliceValues[i] + bobValues[i];
            pq.add(new Pair(aliceValues[i],bobValues[i],totalProfit));
        }

        int bobProfit = 0;
        int aliceProfit = 0;
        boolean flag = true;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(flag){
                aliceProfit += p.totalProfit - p.bobValue;
                flag=false;
            }
            else{
                bobProfit += p.totalProfit - p.aliceValue;
                flag=true;
            }
        }


        if(bobProfit == aliceProfit){
            return 0;
        }
        else if(bobProfit > aliceProfit){
            return -1;
        }
        else{
            return 1;
        }
    }
}