import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int subACnt = 0;
    static int subCCnt = 0;
    static int subGCnt = 0;
    static int subTCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Input 입력 받기
        String[] lenStr = br.readLine().split(" ");
        int S = Integer.parseInt(lenStr[0]); // 민호가 임의로 만든 DNA 문자열 길이
        int P = Integer.parseInt(lenStr[1]); // 비밀번호로 사용할 부분 문자열 길이

        String[] dnaStr = br.readLine().split(""); // 민호가 임의로 만든 DNA 문자열

        String[] dnaCnt = br.readLine().split(" ");
        int aCnt = Integer.parseInt(dnaCnt[0]);
        int cCnt = Integer.parseInt(dnaCnt[1]);
        int gCnt = Integer.parseInt(dnaCnt[2]);
        int tCnt = Integer.parseInt(dnaCnt[3]);

        // 2. 첫 번째 윈도우 배열 생성
        int count = 0;

        for(int i = 0; i < P; i++) {
            plusCount(dnaStr[i]);
        }

        boolean result = checkCount(aCnt, cCnt, gCnt, tCnt);
        if(result) count++;

        for(int i = 1; i < dnaStr.length; i++) {
            if(i + P - 1 >= dnaStr.length) {
                break;
            }

            minusCount(dnaStr[i - 1]);
            plusCount(dnaStr[i + P - 1]);
            
            result = checkCount(aCnt, cCnt, gCnt, tCnt);
            if (result) count++;
        }

        System.out.print(count);
    }

    public static void plusCount(String s) {
        switch(s) {
            case "A":
                subACnt++;
                break;
            case "C":
                subCCnt++;
                break;
            case "G":
                subGCnt++;
                break;
            case "T":
                subTCnt++;
                break;
        }
    }

    public static void minusCount(String s) {
        switch(s) {
            case "A":
                subACnt--;
                break;
            case "C":
                subCCnt--;
                break;
            case "G":
                subGCnt--;
                break;
            case "T":
                subTCnt--;
                break;
        }
    }

    public static boolean checkCount(int a, int c, int g, int t) {
        return subACnt >= a && subCCnt >= c && subGCnt >= g && subTCnt >= t;
    }
}