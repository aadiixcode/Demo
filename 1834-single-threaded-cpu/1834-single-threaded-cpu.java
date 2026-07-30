class Pair {
    int processingTime;
    int taskNumber;

    Pair(int processingTime, int taskNumber) {
        this.processingTime = processingTime;
        this.taskNumber = taskNumber;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        List<List<Integer>> arr = new ArrayList<>();
        int n = tasks.length;
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            List process = new ArrayList<>();
            process.add(task[0]);
            process.add(task[1]);
            process.add(i);
            arr.add(process);
        }
        Collections.sort(arr, (a, b) -> {
            return a.get(0) - b.get(0);
        });



        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.processingTime == b.processingTime) {
                return a.taskNumber - b.taskNumber;
            }
            return a.processingTime - b.processingTime;
        });

        int[] ans = new int[n];
        int index = 0;

        int i = 0;
        int totalTime = 0;
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty() && totalTime < arr.get(i).get(0)) {
                totalTime = arr.get(i).get(0);
            }

            while (i < n) {
                int startTime = arr.get(i).get(0);
                int processingTime = arr.get(i).get(1);
                int taskNumber = arr.get(i).get(2);
                if (startTime <= totalTime) {
                    pq.add(new Pair(processingTime, taskNumber));
                    i += 1;
                } else {
                    break;
                }
            }
            Pair p = pq.poll();
            totalTime += p.processingTime;
            ans[index++] = p.taskNumber;
        }
        return ans;
    }
}