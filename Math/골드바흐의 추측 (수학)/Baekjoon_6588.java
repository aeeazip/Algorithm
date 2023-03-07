package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_6588 {
	public static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		// case 1) 에라토스테네스의 체
		// 출력을 버퍼에 담지 않고, System.out.print로 바로 출력해주면 시간 초과 발생
		
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] isPrime = new boolean[MAX+1];
		for(int i=2; i<=MAX; i++)
			isPrime[i]=true;
		
		for(int i=2; i<=MAX; i++) {
			for(int j=i*2; j<=MAX; j+=i) {
				if(!isPrime[j]) continue;
				isPrime[j]=false;
			}			
		}
		
		while(true) {
			int x = sc.nextInt();
			boolean ok = false;
			
			if(x==0)
				break;
			for(int i=2; i<=x/2; i++) {
				if(isPrime[i] && isPrime[x-i]) {
					bw.write(x + " = " + i + " + " + (x-i) + "\n");
					ok=true;
					break;
				}
			}
			
			if(!ok)
				bw.write("Goldbach's conjecture is wrong.\n");
		}

		bw.flush();
		bw.close();
	}
}
