import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> copy = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            list.add(n);
            copy.add(n);
        }

        Collections.sort(copy); // 정렬

        int index = 0;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < copy.size(); i++) {
            // 1. 스택에 삽입
            if(stack.empty() || !Objects.equals(stack.peek(), list.get(index))) {
                stack.push(copy.get(i));
                sb.append("+");
            }

            // 2. 인덱스 끝까지 왔는데 스택에 값이 남아 있을 때
            if(i == copy.size() - 1 && !stack.empty()) {
                for (int j = stack.size() - 1; j >= 0; j--) {
                    if (!Objects.equals(list.get(index++), stack.pop())) {
                        flag = false;
                        break;
                    } else {
                        sb.append("-");
                    }
                }
                break;
            }

            while(!stack.empty() && Objects.equals(stack.peek(), list.get(index))) {
                stack.pop();
                sb.append("-");
                index++;
            }
        }

        if(!flag) {
            System.out.print("NO");
            return;
        }

        char[] charResult = sb.toString().toCharArray();
        for(int i=0; i<charResult.length - 1; i++) {
            System.out.println(charResult[i]);
        }
        System.out.print(charResult[charResult.length - 1]);
    }
}
