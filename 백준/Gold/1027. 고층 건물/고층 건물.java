import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 기울기
// 자신 기준 오른쪽 : 기울기가 커야 보임
// 자신 기준 왼쪽 : 기울기가 작아야 보임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 빌딩의 수

        int[] buildings = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dpLeft = new int[N];
        int[] dpRight = new int[N];

        /*
            buildings[4]
            15
            1 5 3 2 6 3 2 6 4 2 5 7 3 1 5
                    6
         */
        for(int i = 0; i < N; i++) {
            float leftMin = Integer.MAX_VALUE;
            float rightMax = Integer.MIN_VALUE;

            // 1. 왼쪽 검사
            for(int j = i - 1; j >= 0; j--) {
                int x = i - j;
                int y = buildings[i] - buildings[j];

                if((float) y / x >= leftMin) continue;

                leftMin = (float) y / x;
                dpLeft[i]++;
            }

            // 2. 오른쪽 검사
            for(int j = i + 1; j < N; j++) {
                int x = i - j;
                int y = buildings[i] - buildings[j];

                if((float) y / x <= rightMax) continue;

                rightMax = (float) y / x;
                dpRight[i]++;
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(dpLeft[i] + dpRight[i], max);
        }

        System.out.print(max);
    }
}