import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> bucket;
    static int r;
    static Set<String> checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        r = info[1];
        bucket = new ArrayList<>();
        checked = new HashSet<>();

        int[] num = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 오름차순 정렬
        Arrays.sort(num);

        combination(num, 0, 0);
    }

    public static void combination(int[] num, int start, int k) {
        if(k == r) {
            StringBuilder str = new StringBuilder();
            for(Integer i : bucket) str.append(i + " ");

             if(!checked.contains(str.toString())) {
                 System.out.println(str);
                 checked.add(str.toString());
             }
             return;
        }

        for(int i = start; i < num.length; i++) {
            bucket.add(num[i]);
            combination(num, i + 1, k + 1);
            bucket.remove(bucket.size() - 1);
        }
    }
}