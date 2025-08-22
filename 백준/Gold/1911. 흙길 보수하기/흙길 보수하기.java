import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N = 물웅덩이 갯수
        // L = 널빤지 길이
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // N, L

        int[][] info = new int[arr[0]][2];
        for(int i = 0; i < arr[0]; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            info[i] = input;
        }

        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int result = 0;
        int last = 0;

        for(int i = 0; i < arr[0]; i++) {
            int size = 0;
            int start = 0;

            if(info[i][0] > last) {
                size = info[i][1] - info[i][0];
                start = info[i][0];
            } else {
                size = info[i][1] - last;
                start = last;
            }

            int count = size % arr[1] > 0 ? size / arr[1] + 1 : size / arr[1];
            result += count;
            last = start + arr[1] * count;
        }

        System.out.print(result);
    }
}