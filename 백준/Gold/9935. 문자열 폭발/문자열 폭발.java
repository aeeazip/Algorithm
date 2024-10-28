import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        String[] explosionStr = br.readLine().split("");

        Stack<Integer> stack1 = new Stack<>(); // 폭발 문자열이 아닌 str 문자열
        Stack<Integer> stack2 = new Stack<>(); // str 중 폭발 문자열 후보인 문자열

        for(int i = 0; i < str.length; i++){
            stack1.push(i);

            int index = explosionStr.length - 1;
            while(!stack1.isEmpty() && index >= 0 && str[stack1.peek()].equals(explosionStr[index])) { // 폭발 문자열 검사
                stack2.push(stack1.pop());
                index--;
            }

            if(index != -1) { // 폭발 문자열이 아니라는 뜻
                while(!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            else {
                stack2.clear();
            }
        }

        if(stack1.isEmpty())
            bw.write("FRULA");
        else
            printStack1(bw, str, stack1);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void printStack1(BufferedWriter bw, String[] str, Stack<Integer> stack1) throws IOException {
        if(stack1.isEmpty())
            return;

        int n = stack1.pop();
        printStack1(bw, str, stack1);

        bw.write(str[n]);
    }
}

