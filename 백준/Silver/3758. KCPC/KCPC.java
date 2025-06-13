import java.io.*;
import java.util.*;

public class Main {
    public static class Team implements Comparable<Team> {
        boolean isMyTeam; // 우리팀
        int count; // 풀이 제출 횟수
        int time; // 마지막 풀이 제출 시간
        Map<Integer, Integer> map; // 제출 번호, 점수
        int total; // 최종 점수

        public Team() {
            this.isMyTeam = false;
            this.count = 0;
            this.time = 0;
            this.map = new HashMap<>();
            this.total = 0;
        }

        // Team 정렬 (최종 점수 내림차순, 풀이 제출 횟수 오름차순, 마지막 제출 시간 오름차순)
        @Override
        public int compareTo(Team t) {
            if(this.total != t.total)
                return t.total - this.total;

            if(this.count != t.count)
                return this.count - t.count;

            return this.time - t.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 테케 개수
        int index = 0;

        while(index++ < N) {
            int[] info = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int n = info[0]; // 팀 개수
            int k = info[1]; // 문제 개수
            int t = info[2]; // 팀id
            int m = info[3]; // 로그 개수

            Team[] team = new Team[n + 1];
            for(int i = 0; i < n + 1; i++) {
                team[i] = new Team();
            }

            for(int i = 0; i < m; i++) {
                // 팀id, 문제 번호, 점수
                info = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                team[info[0]].count++; // 팀 풀이 횟수 증가
                team[info[0]].time = i; // 팀 마지막 풀이 시간 업데이트

                Integer point = team[info[0]].map.get(info[1]); // 팀에 풀이 이력이 있는지

                // 이력 없거나, 현재 점수가 더 크면 추가 및 업데이트
                if (point == null || point < info[2]) {
                    team[info[0]].map.put(info[1], info[2]);
                    team[info[0]].total += info[2];

                    if (point != null) {
                        team[info[0]].total -= point;
                    }
                }
            }

            // 결과 구하기
            team[t].isMyTeam = true; // 우리팀 기록
            Arrays.sort(team);

            for(int j = 0; j < n + 1; j++) {
                if(team[j].isMyTeam) {
                    bw.write(j + 1 + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}