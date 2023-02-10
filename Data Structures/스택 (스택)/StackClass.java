package baekjoon;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_10828 {
	// 스택 클래스로 구현 
	// push, pop, size, peek, isEmpty, isFull 함수 이미 구현되어 있음 -> 코드 단축 가능
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result;

		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");

			if(str[0].equals("push"))
				stack.push(Integer.parseInt(str[1]));

			else if(str[0].equals("pop")) {
				if(stack.isEmpty())
					System.out.println("-1");
				else {
					System.out.println(stack.peek());
					stack.pop();
				}
			}

			else if(str[0].equals("top")) {
				if(stack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(stack.peek());
			}

			else if(str[0].equals("size"))
				System.out.println(stack.size());

			else if(str[0].equals("empty"))
				System.out.println(result = (stack.empty() == true) ? 1 : 0);

		}
	}
}