import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[] pos = new int[N]; // 집 좌표
        for(int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(pos);

        int left = 1; // 최소 거리
        int right = pos[N - 1] - pos[0]; // 가능한 최대 거리
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2; // 공유기 간 최소 거리

            if(canInstall(pos, N, C, mid)) { // 공유기를 mid 거리 이상 배치 가능 = mid 늘리기
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1; // mid 줄이기
            }
        }

        System.out.print(answer);
    }

    // 공유기를 mid 거리 이상으로 배치할 수 있는지 확인
    public static boolean canInstall(int[] pos, int N, int C, int mid) {
        int count = 1; // 첫 집에 무조건 설치
        int prev = pos[0]; // 첫 집 위치

        for(int i = 1; i < N; i++) {
            if(pos[i] - prev >= mid) {
                prev = pos[i];
                count++;
            }
        }

        return count >= C;
    }
}