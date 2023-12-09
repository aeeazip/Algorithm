import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            TO DO 반례 테스트 케이스 (단순히 종료 시간으로만 정렬 X + 종료시간 같은 경우 시작시간으로 정렬!!)

            2
            10 10
            1 10
            2
        */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Meeting> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        // 종료 시간을 기준으로 오름차순 정렬 (시작 시간으로 2차 정렬)
        Collections.sort(list, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                // 종료 시간을 기준으로 비교
                int endComparison = Integer.compare(o1.end, o2.end);

                // 종료 시간이 같은 경우 시작 시간으로 정렬
                if(endComparison == 0)
                    return Integer.compare(o1.start, o2.start);

                return endComparison;
            }
        });

        int count = 1;
        int lastEnd = list.get(0).end;  // 마지막으로 선택된 회의의 끝나는 시간

        for(int i = 1; i < n; i++) {
            if(list.get(i).start >= lastEnd){
                lastEnd = list.get(i).end;
                count++;
            }
        }

        System.out.println(count);
    }
}
