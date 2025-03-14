import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();

        // 'a' 개수 세기
        int aCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') aCnt++;
        }

        // 문자열을 두 배로 확장
        String extended = s + s;

        // 초기 윈도우 (길이 aCnt)에서 'b' 개수 세기
        int bCnt = 0;
        for (int i = 0; i < aCnt; i++) {
            if (extended.charAt(i) == 'b') bCnt++;
        }
        int minSwap = bCnt; // 첫 구간에서 b 개수 기록

        // 슬라이딩 윈도우로 최소 b 개수 찾기
        for (int i = 1; i < n; i++) {
            if (extended.charAt(i - 1) == 'b') bCnt--; // 왼쪽 끝 문자 제거
            if (extended.charAt(i + aCnt - 1) == 'b') bCnt++; // 오른쪽 새 문자 추가

            minSwap = Math.min(minSwap, bCnt);
        }

        System.out.print(minSwap);
    }
}
