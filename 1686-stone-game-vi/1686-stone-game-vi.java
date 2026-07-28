class Pair{
    int index;
    int profit;
    Pair(int index,int profit){
        this.index = index;
        this.profit = profit;
    }
}

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            if(a.profit==b.profit){
                return aliceValues[b.index] - aliceValues[a.index];
            }
            return b.profit - a.profit;
        });
        
        for(int i=0;i<n;i++){
            int totalProfit = aliceValues[i] + bobValues[i];
            pq.add(new Pair(i,totalProfit));
        }

        int bobProfit = 0;
        int aliceProfit = 0;
        boolean flag = true;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int index = p.index;
            int profit = p.profit;
            if(flag){
                aliceProfit += profit - bobValues[index];
                flag=false;
            }
            else{
                bobProfit += profit - aliceValues[index];
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