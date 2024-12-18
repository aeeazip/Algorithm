//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
//
//        for(int i = 0; i < T; i++) {
//            String[] p = br.readLine().split(""); // 함수
//            int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수
//            String[] arr = br.readLine().split(","); // 배열
//            arr[0] = arr[0].substring(1, arr[0].length());
//            arr[arr.length - 1] = arr[arr.length - 1].substring(0, arr[arr.length - 1].length() - 1);
//
//            bw.write(solution(p, arr) + "\n");
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    public static String solution(String[] p, String[] arr) {
//        StringBuilder sb = new StringBuilder();
//
//        int start = 0;
//        int end = arr.length - 1;
//        boolean isForward = true; // 순방향
//
//        if(start == end && Arrays.stream(p).anyMatch("D"::equals))
//            return "error";
//
//        // R : 순서 뒤집기
//        // D : 첫 번째 수 버리기 (배열이 비어있으면 에러 발생)
//
//        for(int i = 0; i < p.length; i++) {
//
//            if("R".equals(p[i])) {
//                System.out.println("\n현재 R");
//                isForward = !isForward;
//                int temp = start;
//                start = end;
//                end = temp;
//            }
//
//            if("D".equals(p[i])) {
//                System.out.println("현재 D");
//
//                // 순방향일 때 end < start / 역방향일 때 start < end -> error
//                if((isForward && end < start) || (!isForward && start < end))
//                    return "error";
//
//                if(isForward) {
//                    start++;
//                } else {
//                    start--;
//                }
//            }
//
//            if(isForward) {
//                for(int j = start; j <= end; j++) {
//                    System.out.print(arr[j] + ",");
//                }
//                System.out.println();
//            } else {
//                for(int j = start; j >= end; j--) {
//                    System.out.print(arr[j] + ",");
//                }
//                System.out.println();
//            }
//        }
//        if(isForward) {
//            if(start > end)
//                return "[]";
//
//            sb.append("[");
//            for(int i = start; i < end; i++) {
//                sb.append(arr[i] + ",");
//            }
//
//            if(end >= start) {
//                sb.append(arr[end]);
//            }
//            sb.append("]");
//        } else {
//            if(start < end) {
//                return "[]";
//            }
//
//            sb.append("[");
//            for(int i = start; i > end; i--) {
//                sb.append(arr[i] + ",");
//            }
//
//            if(end <= start) {
//                sb.append(arr[end]);
//            }
//            sb.append("]");
//        }
//
//        return sb.toString();
//    }
//}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i = 0; i < T; i++) {
            String[] p = br.readLine().split(""); // 함수
            int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수
            String[] arr = br.readLine().split(","); // 배열
            arr[0] = arr[0].substring(1, arr[0].length());
            arr[arr.length - 1] = arr[arr.length - 1].substring(0, arr[arr.length - 1].length() - 1);

            bw.write(solution(p, arr) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String solution(String[] p, String[] arr) {
        StringBuilder sb = new StringBuilder();

        int start = 0;
        int end = arr.length - 1;
        boolean isForward = true; // 순방향

        if(arr[0].length() == 0 && Arrays.stream(p).anyMatch("D"::equals))
            return "error";

        // R : 순서 뒤집기
        // D : 첫 번째 수 버리기 (배열이 비어있으면 에러 발생)

        for(int i = 0; i < p.length; i++) {

            if("R".equals(p[i])) {
                isForward = !isForward;
                int temp = start;
                start = end;
                end = temp;
            }

            if("D".equals(p[i])) {
                // 순방향일 때 end < start / 역방향일 때 start < end -> error
                if((isForward && end < start) || (!isForward && start < end))
                    return "error";

                if(isForward) {
                    start++;
                } else {
                    start--;
                }
            }
        }

        if(isForward) {
            if(start > end)
                return "[]";

            sb.append("[");
            for(int i = start; i < end; i++) {
                sb.append(arr[i] + ",");
            }

            if(end >= start) {
                sb.append(arr[end]);
            }
            sb.append("]");
        } else {
            if(start < end) {
                return "[]";
            }

            sb.append("[");
            for(int i = start; i > end; i--) {
                sb.append(arr[i] + ",");
            }

            if(end <= start) {
                sb.append(arr[end]);
            }
            sb.append("]");
        }

        return sb.toString();
    }
}