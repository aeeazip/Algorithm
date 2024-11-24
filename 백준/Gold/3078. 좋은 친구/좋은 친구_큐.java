import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long count = 0; // 결과 저장
        int[] nameLength = new int[N];
        int[] goodFriend = new int[21]; // 이름 최대 길이는 20

        for(int i = 0; i < N; i++) {
            nameLength[i] = br.readLine().length();
        }

        for(int i = 0; i < goodFriend.length; i++) { // 초기화
            goodFriend[i] = 0;
        }

        // 슬라이딩 윈도우 사용하기 위해 첫 번째 작은 배열 먼저 계산
        for(int i = 0; i < K + 1; i++) {
            if(i < N) {
                goodFriend[nameLength[i]]++;
            }
        }
        count += goodFriend[nameLength[0]] - 1; // 자기 자신 제외

        // 나머지 영역 계산
        for(int i = 1; i < N; i++) {
            goodFriend[nameLength[i - 1]]--; // 윈도우 영역이 아닌 값 제외
            if(i + K < N) {
                goodFriend[nameLength[i + K]]++; // 윈도우 영역인 값 삽입
            }
            count += goodFriend[nameLength[i]] - 1; // 자기 자신 제외
        }

        System.out.print(count);
    }
}
