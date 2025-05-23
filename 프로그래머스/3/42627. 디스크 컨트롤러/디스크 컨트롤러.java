import java.util.*;

class Solution {
    public static class Node implements Comparable<Node> {
        int num; // 작업번호
        int reqTime; // 요청시간
        int useTime; // 소요시간

        public Node(int num, int reqTime, int useTime) {
            this.num = num;
            this.reqTime = reqTime;
            this.useTime = useTime;
        }

        @Override
        public int compareTo(Node node) {
            // 1. 작업 소요 시간이 짧은 것
            if(this.useTime != node.useTime)
                return Integer.compare(this.useTime, node.useTime);

            // 2. 작업 요청 시각이 빠른 것
            if(this.reqTime != node.reqTime)
                return Integer.compare(this.reqTime, node.reqTime);

            // 3. 작업 번호가 작은 것
            return Integer.compare(this.num, node.num);
        }
    }

    public int solution(int[][] jobs) {
        // jobs에 작업 요청 시점, 작업 소요 시간 저장
        // 요청 시간 순서로 정렬 순서
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        PriorityQueue<Node> queue = new PriorityQueue<>();

        int index = 0; // 큐에 넣을 작업 인덱스
        int time = 0; // 현재 시간
        int totalTime = 0; // 총 반환시간
        int completed = 0;

        while(completed < jobs.length) {
            // 현재 시간까지 들어온 작업들을 대기 큐에 넣음
            while(index < jobs.length && jobs[index][0] <= time) {
                queue.add(new Node(index, jobs[index][0], jobs[index][1]));
                index++;
            }

            if(!queue.isEmpty()) { // 대기큐에 들어온 값이 있으면
                Node node = queue.poll();
                time += node.useTime;
                totalTime += time - node.reqTime;
                completed++;
            } else { // 대기큐에 들어온 값이 없으면
                time++;
            }
        }

        return totalTime / jobs.length;
    }
}