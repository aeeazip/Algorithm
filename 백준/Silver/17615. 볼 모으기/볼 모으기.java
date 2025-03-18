import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        List<Integer> list = new ArrayList<>();

        int count = 1;
        String now = str[0];
        for(int i = 1; i < N; i++) {
            if(now.equals(str[i])) {
                count++;
            } else {
                list.add(count);
                count = 1;
                now = str[i];
            }

            if(i == N - 1) list.add(count);
        }

        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        if(list.size() % 2 == 0) { // 리스트 개수가 짝수 = 처음과 끝 문자가 다름
            // 맨처음과 같은 것을 맨 앞으로 몰기
            for(int i = 1; i < list.size(); i++) {
                if(i % 2 == 0) count1 += list.get(i);
            }

            // 맨처음과 같은 것을 맨 끝으로 몰기
            for(int i = 0; i < list.size(); i++) {
                if(i % 2 == 0) count2 += list.get(i);
            }

            // 맨끝과 같은 것을 맨 앞으로 몰기
            for(int i = 0; i < list.size(); i++) {
                if(i % 2 != 0) count3 += list.get(i);
            }

            // 맨끝과 같은 것을 맨 뒤로 몰기
            for(int i = 0; i < list.size() - 1; i++) {
                if(i % 2 != 0) count4 += list.get(i);
            }

            int min = Math.min(Math.min(count1, count2), Math.min(count3, count4));
            System.out.print(min);
        } else { // 처음과 끝 문자가 같음
            // 맨처음과 같은 것을 맨 앞으로 몰기
            for(int i = 1; i < list.size(); i++) {
                if(i % 2 == 0) count1 += list.get(i);
            }

            // 맨처음과 같은 것을 맨 끝으로 몰기
            for(int i = 0; i < list.size() - 1; i++) {
                if(i % 2 == 0) count2 += list.get(i);
            }

            // 중앙걸 맨 앞으로 몰기
            for(int i = 1; i < list.size(); i++) {
                if(i % 2 != 0) count3 += list.get(i);
            }

            int min = Math.min(Math.min(count1, count2), count3);
            System.out.print(min);
        }
    }
}