import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 30분
public class Main {
    public static BufferedWriter bw;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        List<Integer> picked = new ArrayList<>();
        dfs(M, picked, 0);
        bw.flush();
    }

    public static void dfs(int M, List<Integer> picked, int k) throws IOException {
        if(M == k) {
            for(Integer n : picked) bw.write(n + " ");
            bw.write("\n");
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            picked.add(arr[i]);
            dfs(M, picked, k + 1);
            picked.remove(picked.size() - 1);
        }
    }
}