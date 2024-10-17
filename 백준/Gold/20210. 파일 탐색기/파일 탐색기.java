import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static class Word implements Comparable<Word> {
        String[] str;

        public Word(String[]str){
            this.str = str;
        }

        public String getString() {
            String s = "";

            for(int i = 0; i < str.length; i++) {
                s += str[i];
            }
            return s;
        }

        // 소문자(0), 대문자(1), 숫자 타입(2)
        public int checkType (String s) {
            char c = s.charAt(0);

            if(Character.isLowerCase(c)) // 소문자
                return 0;
            else if(Character.isUpperCase(c)) // 대문자
                return 1;
            return 2;
        }

        public String makeStrNum(String[] s, int x) {
            String num = s[x];

            for(int i = x + 1; i < s.length; i++) {
                if(checkType(s[i]) == 2)
                    num += s[i];
                else
                    break;
            }
            return num;
        }

        public int countZero(String num) {
            int count = 0;

            for(int i = 0; i < num.length();  i++) {
                if(num.charAt(i) == '0')
                    count++;
                else
                    return count;
            }
            return count;
        }

        public String makeNewNum(String num, int n) {
            String newNum = "";

            if(n == 0)
                return num;

            for(int i = n; i < num.length(); i++) {
                newNum += String.valueOf(num.charAt(i));
            }
            return newNum;
        }

        @Override
        public int compareTo(Word o) {
            for (int i = 0; i < 100; i++) {
                if(Math.min(this.str.length, o.str.length) == i) { // 끝까지 왔는데 판별 못하는 경우
                    if(this.str.length > o.str.length)
                        return 1;
                    return -1;
                }

                // 소문자(0), 대문자(1), 숫자 타입(2) 체크
                int type1 = checkType(this.str[i]);
                int type2 = checkType(o.str[i]);

                // 1. 둘 다 문자일 때
                if (type1 <= 1 && type2 <= 1) { // 둘 다 문자일 때
                    if (this.str[i].equals(o.str[i])) // 값이 같으면 다음으로 넘어가기
                        continue;

                    // 둘 중 하나가 소문자일 때
                    if(type1 == 0 && type2 == 1) {
                        return this.str[i].toUpperCase().charAt(0) < o.str[i].charAt(0) ? -1 : 1;
                    } else if(type1 == 1 && type2 == 0) {
                        return o.str[i].toUpperCase().charAt(0) < this.str[i].charAt(0) ? 1 : -1;
                    }
                    return this.str[i].compareTo(o.str[i]);
                }

                // 2. 둘 중 하나가 숫자일 때
                if (type1 != type2 && (type1 == 2 || type2 == 2)) {
                    if (type1 == 2) // this가 숫자일 때
                        return -1;
                    return 1; // o가 숫자일 때
                }

                // 3. 둘 다 숫자일 때
                String num1 = makeStrNum(this.str, i);
                String num2 = makeStrNum(o.str, i);

                if(num1.equals(num2))
                    continue;

                int num1Zero = countZero(num1);
                int num2Zero = countZero(num2);

                String newNum1 = makeNewNum(num1, num1Zero);
                String newNum2 = makeNewNum(num2, num2Zero);

                if(newNum1.equals(newNum2) && num1Zero != 0)
                    return num1Zero < num2Zero ? -1 : 1;
                else {
                    if (newNum1.length() == newNum2.length()) { // 길이 같을 때
                        for (int j = 0; j < newNum1.length(); j++) {
                            if(newNum1.charAt(j) == newNum2.charAt(j))
                                continue;
                            if (newNum1.charAt(j) - newNum2.charAt(j) > 0)
                                return 1;
                            else return -1;
                        }
                    }
                    return newNum1.length() > newNum2.length() ? 1 : -1;
                }
            }

            return 0; // 모든 요소가 동일한 경우
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Word> array = new ArrayList<Word>();
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            Word word = new Word(input);
            array.add(word);
        }

        Collections.sort(array);
        for(Word word : array) {
            bw.write(word.getString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}