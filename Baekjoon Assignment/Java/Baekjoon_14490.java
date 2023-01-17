package baekjoon;

import java.util.*;
public class Baekjoon_14490 {
    public static void main(String[] args){
        String TAG = "Baekjoon_14990";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] num = str.split(":");

        int x = Integer.parseInt(num[0]);
        int y = Integer.parseInt(num[1]);

        Log.d(TAG, x);
        Log.d(TAG, y);
    }
}