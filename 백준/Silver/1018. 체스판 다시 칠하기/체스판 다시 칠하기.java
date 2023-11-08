import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 바둑판에서 다시 색칠해야하는 정사각형의 개수를 세는 함수
    public static int countRepaint(int x, int y, String[][] input, String start) {
        int count = 0;

        // 8 * 8 바둑판 (start와 현재값을 비교)
        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                if((i - x + j - y) % 2 == 0)    // 짝수행 + 짝수열 or 홀수행 + 홀수열 -> start와 일치해야함
                    count = start.equals(input[i][j]) ? count : count + 1;
                else                            // 홀수행 + 짝수열 or 짝수형 + 홀수열 -> start와 불일치해야 함
                    count = !start.equals(input[i][j]) ? count : count + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");

        int M = Integer.parseInt(size[0]);
        int N = Integer.parseInt(size[1]);

        String[][] input = new String[M][N];
        for(int i = 0; i < M; i++) {
            String[] baduk = br.readLine().split("");
            for(int j = 0; j < N; j++)
                input[i][j] = baduk[j];
        }

        int min = M * N;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if ((i + 8 > M) || (j + 8 > N))
                    continue;

                // 체스판 왼쪽 제일 위가 B / W 중 하나 (이 값도 변할 수 있음!!!!!!!!!!!!!!!!!!!!!!!!!)
                int countB = countRepaint(i, j, input, "B");
                int countW = countRepaint(i, j, input, "W");

                min = Math.min(min, Math.min(countB, countW));
            }
        }

        System.out.println(min);
    }
}