import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int N;
    public static int[] temp;
    public static long swap = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        temp = new int[N];
        mergeSort(arr, 0, N - 1);

        System.out.print(swap);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int k = left;

        while(l <= mid && r <= right) {
            if(arr[l] <= arr[r]) {
                temp[k++] = arr[l++];
            }
            else {
                /**
                 * swap 발생
                 * 왼쪽 배열은 left ~ mid까지 정렬됨
                 * 오른쪽 배열은 mid + 1 ~ right까지 정렬됨
                 * 오른쪽 원소(arr[r])가 왼쪽 원소(arr[l])보다 작으면 왼쪽 모든 원소보다 작음 (이미 정렬되어 있으니까)
                 * ex) 7 8 9 | 2 3 4
                 *     l       r
                 */
                temp[k++] = arr[r++];
                swap += (mid - l + 1);
            }
        }

        while(l <= mid) temp[k++] = arr[l++]; // 왼쪽 다 못 담은 경우
        while(r <= right) temp[k++] = arr[r++]; // 오른쪽 다 못 담은 경우

        for(int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}