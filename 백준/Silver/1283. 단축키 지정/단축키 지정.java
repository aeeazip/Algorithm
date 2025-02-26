import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] alpha = new boolean[26];

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int shortIdx1 = -1, shortIdx2 = -1;

            // 1. 첫번째 단어의 첫번째 글자가 단축키인가
            for(int j = 0; j < str.length; j++) {
                String word = str[j].toUpperCase();
                if(!alpha[word.charAt(0) - 'A']) {
                    alpha[word.charAt(0) - 'A'] = true;
                    shortIdx1 = j; shortIdx2 = 0;
                    break;
                }
            }

            // 2. 모든 단어 첫글자가 이미 지정되어있는가
            if(shortIdx1 == -1 && shortIdx2 == -1) {
                for(int j = 0; j < str.length; j++) {
                    String word = str[j].toUpperCase();
                    for(int k = 0; k < str[j].length(); k++) {
                        if(!alpha[word.charAt(k) - 'A']) {
                            alpha[word.charAt(k) - 'A'] = true;
                            shortIdx1= j; shortIdx2 = k;
                            break;
                        }
                    }

                    if(shortIdx1 != -1 && shortIdx2 != -1) {
                        break;
                    }
                }
            }

            for(int j = 0; j < str.length; j++) {
                for(int k = 0; k < str[j].length(); k++) {
                    if(shortIdx1 == j && shortIdx2 == k) {
                        bw.write("[" + str[j].charAt(k) + "]");
                    } else {
                        bw.write(str[j].charAt(k));
                    }
                }
                bw.write(" ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}