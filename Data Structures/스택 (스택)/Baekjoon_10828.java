package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10828 {

	static Object[] stackArray;
	static int top;
	static int maxSize;
	
	// 생성자로 초기화
	public Baekjoon_10828(int maxSize) {
		top = -1;
		this.maxSize = maxSize;
		stackArray = new Object[maxSize];
	}
	
	// 스택이 비어있는 검사하는 함수 
	// 스택의 크기가 주어지지 않았기 때문에 isFull 구현할 필요 X
	public static int isEmpty() {
		if(top == -1)
			return 1;
		return 0;
	}
	
	public static int isFull() {
		if(top == maxSize - 1)
			return 1;
		return 0;
	}
	
	// 스택에 들어있는 정수의 개수를 출력
	public static int size() {
		return (top + 1);
	}
	
	// 스택에 원소를 삽입하는 함수
	public static void push(int n) {
		if(isFull() != 1)
			stackArray[++top] = n;
	}
	
	// 스택 최상단에 있는 원소를 엿보는 함수
	public static int peek() {
		if(isEmpty() != 1)
			return (int) stackArray[top];
		return -1;
	}
	
	// 스택 최상단에 있는 원소를 삭제하는 함수
	public static int pop() {
		if(isEmpty() == 1)
			return -1;
		return (int) stackArray[top--];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Baekjoon_10828 stack = new Baekjoon_10828(n);	// 생성자로 스택 초기화
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			
			if(str[0].equals("push"))
				push(Integer.parseInt(str[1]));
			
			else if(str[0].equals("pop"))
				System.out.println(pop());
			
			else if(str[0].equals("top"))
				System.out.println(peek());
			
			else if(str[0].equals("size"))
				System.out.println(size());
			
			else if(str[0].equals("empty"))
				System.out.println(isEmpty());
		}
	}

}
