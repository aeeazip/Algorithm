import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 입력 받아서 큐 배열에 넣기
        LinkedList<String>[] queues = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            queues[i] = new LinkedList<>();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                queues[i].offer(input[j]);
                count++;
            }
        }

        // 2. 큐 배열 순서대로 검사
        String[] cseteram = br.readLine().split(" ");
        for (int i = 0; i < cseteram.length; i++) {
            for (int j = 0; j < N; j++) {
                while (!queues[j].isEmpty() && Objects.equals(queues[j].peek(), cseteram[i])) {
                    queues[j].poll();
                }
            }
        }

        boolean flag = true;
        for(int i = 0; i < N; i++) {
            if(!queues[i].isEmpty()) {
                flag = false;
            }
        }

        if(flag && count == cseteram.length) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }

    }
}