import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> list = new ArrayList<>(); // 증가하는 부분 수열 원소 저장

        for(int num : arr) {
            /*
                Collections.binarySearch : 이분탐색으로 num의 index를 찾아줌
                - binarySearch는 정렬되어 있어야 사용 가능
                - 증가하는 부분 수열을 구해야 함 -> 오름차순으로 정렬된 결과가 list에 저장되므로 사용 가능
                (1) num이 리스트에 있다면 num의 인덱스 반환
                (2) num이 리스트에 없다면 -(인덱스 + 1) 반환
             */

            int index = Collections.binarySearch(list, num);

            if(index < 0) { // 리스트에 num이 존재하지 않는다는 뜻
                index = Math.abs(index) - 1; // 원래 인덱스 계산
            }

            if(list.size() == index) {
                list.add(num);
            } else {
                list.set(index, num);
            }
        }

        System.out.print(list.size());
    }
}
