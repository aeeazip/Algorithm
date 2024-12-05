import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);

            if(x == 0 && y == 0 && z == 0) // 종료 조건
                break;

            if(isInvalid(x, y, z)) {
                bw.write("Invalid\n");
            } else if(isEquilateral(x, y, z)) {
                bw.write("Equilateral\n");
            } else if(isIsosceles(x, y, z)) {
                bw.write("Isosceles\n");
            } else {
                bw.write("Scalene\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 세 변의 길이가 모두 같은 경우
    public static boolean isEquilateral(int x, int y, int z) {
        return x == y && y == z;
    }

    // 두 변의 길이만 같은 경우
    public static boolean isIsosceles(int x, int y, int z) {
        return (x == y && y != z) || (x == z && y != z) || (y == z && z != x);
    }

    // 세 변의 길이가 모두 다른 경우
    public static boolean isScalene(int x, int y, int z) {
        return x != y && y != z && z != x;
    }

    // 삼각형 조건을 만족하지 못하는 경우
    public static boolean isInvalid(int x, int y, int z) {
        int[] num = { x, y, z };
        int max = Math.max(x, Math.max(y, z));
        int sumOfOthers = Arrays.stream(num).sum() - max; // 가장 긴 변 제외 합

        return sumOfOthers <= max;
    }
}