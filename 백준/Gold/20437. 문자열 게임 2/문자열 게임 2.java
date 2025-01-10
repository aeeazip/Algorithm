import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] input = br.readLine().split("");
            int K = Integer.parseInt(br.readLine());

            Point p = check(input, K);

            // System.out.println(p.x + " " + p.y);

            if(p.x == input.length + 1 && p.y == -1) bw.write("-1\n");
            else bw.write(p.x + " " + p.y + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static Point check(String[] input, int K) {
        int min = input.length + 1;
        int max = -1;
        ArrayList<Integer>[] list = new ArrayList[26];

        for(int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < input.length ; i++) {
            list[input[i].charAt(0) - 'a'].add(i);
        }

        for(int i = 0; i < 26; i++) {
            if(list[i].size() < K) continue;

            for(int j = 0; j <= list[i].size() - K; j++) {
                int result = list[i].get(j + K - 1) - list[i].get(j) + 1;
                min = Math.min(min, result);
                max = Math.max(max, result);
            }
        }

        return new Point(min, max);
    }
}
