package baekjoon;

import java.util.Scanner;
 
public class Baekjoon_11729 {
 
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
 
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');
 
		Hanoi(N, 1, 2, 3);
		System.out.println(sb);
 
	}
 
	public static void Hanoi(int N, int start, int mid, int to) {
		// 이동할 원반의 수가 1개인 경우
		if (N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
 
		// A -> C로 옮긴다고 가정할 떄,
		// STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
		Hanoi(N - 1, start, to, mid);
    
		// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
		sb.append(start + " " + to + "\n");
    
		// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
		Hanoi(N - 1, mid, start, to);
 
	}
}