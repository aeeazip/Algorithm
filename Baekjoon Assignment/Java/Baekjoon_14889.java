package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon_14889 {
	static int n;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		visit = new boolean[n];
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		back(0,0);
		System.out.println(min);

	}

	private static void back(int depth,int start) {
		// TODO Auto-generated method stub
		if (depth == n / 2) {
			int[] arr = new int[n / 2];
			int[] arr2 = new int[n / 2];
			int j = 0, k = 0;
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					arr[j++] = i;
				} else {
					arr2[k++] = i;
				}
			}

			int s = start(arr);

			int l = link(arr2);

			min = Math.min(min, Math.abs(s - l));
			return;

		}

		for (int i = start; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				back(depth + 1,i+1);
				visit[i] = false;

			}
		}

	}

	private static int start(int[] start) {

		int sum = 0;
		for (int i = 0; i < start.length; i++) {
			for (int j = 0; j < start.length; j++) {
				if (i == j)
					continue;
				int x = start[i];
				int y = start[j];
				sum += map[x][y];

			}
		}
		return sum;
	}

	private static int link(int[] link) {

		int sum = 0;
		for (int i = 0; i < link.length; i++) {
			for (int j = 0; j < link.length; j++) {
				if (i == j)
					continue;
				int x = link[i];
				int y = link[j];
				sum += map[x][y];

			}
		}

		return sum;
	}

}

/*package FinalExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_14889 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		boolean[] visit = new boolean[n];

		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<n; j++)
				arr[i][j] = Integer.parseInt(str[j]);
		}

		back(0,0);
		System.out.println()
	}

}
 */
