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
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            List l = new ArrayList<>();
            l.add(task[0]);
            l.add(task[1]);
            l.add(i);
            arr.add(l);
        }
        Collections.sort(arr, (a, b) -> {
            // if (a.get(0) == b.get(0)) {
                // return a.get(1) - b.get(1);
            // }
            return a.get(0) - b.get(0);
        });
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.processingTime == b.processingTime) {
                return a.taskNumber - b.taskNumber;
            }
            return a.processingTime - b.processingTime;
        });

        int n = tasks.length;
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