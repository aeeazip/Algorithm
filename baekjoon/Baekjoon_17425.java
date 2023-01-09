package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_17425 {

	// BufferedReader로 한 번에 쭉쭉 읽고 BufferedWriter로 한 번에 쫙 출력해야 시간 단축 가능
	// n=10일 때 F(10)=1+2+5+10=18 -> G(10)=F(1)+F(2)+F(3)...+F(10)

	// 첫 줄에 입력받을 수의 개수 + 숫자 쭉 입력받기
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 받는 수의 최대값이 1000000이기 때문에 array를 인덱스 1부터 참조하기 위해 +1한 크기로 만들었다.
		long[] f = new long[1000001]; 
		long[] g = new long[1000001];
		// 1은 모든 수의 약수이므로 1로 초기화
		Arrays.fill(f, 1);

		// 두 번째 반복문의 조건이 i*j<1000000인 이유는
		// 입력 받는 수의 최대값이 1000000이므로 최대 약수도 1000000을 넘을 수 없기 때문이다.
		for(int i=2; i<=1000000; i++) {
			for(int j=1; i*j<=1000000; j++) {
				// i=2, j=1인 경우 2X1=2 즉, 해당 식에서 2가 약수가 되므로 i 값을 더해준다.
				f[i*j] += i;
			}
			// 배열을 f 하나만 사용하는 경우엔 아래식 추가
			//f[i] = f[i-1] + f[i];
		}

		for(int i=1; i<=1000000; i++)
			g[i] = g[i-1] + f[i];

		// br.readLine()으로 읽어들인 값은 String이므로 타입 캐스팅 필요
		// n = 테스트 케이스 개수
		int n = Integer.parseInt(br.readLine());

		// 문장 전체를 읽어들인 경우 stop
		while(n-->0) {
			bw.write(g[Integer.parseInt(br.readLine())] + "\n");
		}

		// 스트림을 닫지 않은 상태에서 바이트를 보내고 싶은 경우(플러쉬를 해야하는 경우) 사용
		bw.flush();
	}
}



/* 
 * 교수님 예제 1
 public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf;
		StringBuilder sb = new StringBuilder();
		long v[];
		long sum[];
		int nums;
		int num_array[];
		int max_num;

		bf = new BufferedReader(new InputStreamReader(System.in));
		nums = Integer.parseInt(bf.readLine());
		num_array = new int[nums];
		for(int i=0; i<nums;i++) {
			num_array[i] = Integer.parseInt(bf.readLine());
		}

		max_num = num_array[0];
		for(int i=1; i<nums;i++) {
			if( max_num < num_array[i] )
				max_num = num_array[i];
		}

		v = new long[max_num+1];
		sum = new long[max_num+1];

		for(int i = 1; i <= max_num; i++) { 
			v[i] = 1;
		}

		for(int i = 2; i <= max_num; i++) { 
			for(int j = 1; j*i <= max_num; j++) { 
				v[j*i] += i; 
			}
		}

		for(int i = 1; i <= max_num; i++){
			sum[i] = sum[i-1] + v[i]; 
		}

		for(int i=0; i<nums;i++) {
			sb.append(sum[num_array[i]] +"\n");
		}
		System.out.println(sb.toString()); -> Buffer에 모아서 한 번에 출력하지 않으면 타임아웃
	}
 */

/*
 * 교수님 예제 2
 * -> 겹치는 연산이 많아서 타임 아웃 발생 -> 메모이제이션 활용
 * public static long calcSumDivisor(int n) { //F(n)
								if ( n == 1 ) return 1;
								long ret = 1 + n;

								// Q. 왜 루프가 i<=n/2까지?
								for(int i = 2; i <= n/2; i++ ) {
												if ( n % i == 0 )
																ret = ret + i;
								}
								return ret;
				}

				public static long calcSum(int n) { //G(n)
								if(n==1) return 1;
								return calcSum(n-1) + calcSumDivisor(n);
				}

				public static void main(String[] args) throws NumberFormatException, IOException {
								BufferedReader bf;
								StringBuilder sb = new StringBuilder();
								int nums;
								int num_array[];

								bf = new BufferedReader(new InputStreamReader(System.in));
								nums = Integer.parseInt(bf.readLine());
								num_array = new int[nums];
								for(int i=0; i<nums;i++) {
												num_array[i] = Integer.parseInt(bf.readLine());
								}

								for(int i=0; i<nums;i++) {
												long sum = calcSum(num_array[i]);
												sb.append(sum+"\n");
								}
								System.out.println(sb.toString());
				}
 */

/*
 * 교수님 예제 3
 * 메모이제이션 활용 -> F(n)은 한 번씩만 계산 but G(n)은 여전히 중복 계산
 * -> G(3) = F(1)+F(2)
 * -> G(4) = F(1)+F(2)+F(3)
 * ...
 * 연산이 겹치는 부분이 발생 -> G도 메모이제이션 활용 (G(n)=G(n-1)+F(n))
 * public static long calcSumDivisor(int n, long []M) {

								if(M[n] != 0) return M[n];
								if ( n == 1 ) return 1;

								long ret = 1 + n;

								for(int i = 2; i <= n/2; i++ ) {
												if ( n % i == 0 )
																ret = ret + i;
								}
								M[n] = ret;
								return M[n];
				}

				public static long calcSum(int n, long []M) {
								if(n==1) return 1;
								return calcSum(n-1,M) + calcSumDivisor(n,M);
				}

				public static void main(String[] args) throws NumberFormatException, IOException {
								BufferedReader bf;
								StringBuilder sb = new StringBuilder();
								int nums;
								int num_array[];
								int max_num;

								bf = new BufferedReader(new InputStreamReader(System.in));
								nums = Integer.parseInt(bf.readLine());
								num_array = new int[nums];
								for(int i=0; i<nums;i++) {
												num_array[i] = Integer.parseInt(bf.readLine());
								}

								// 메모 공간의 크기 결정
								max_num = num_array[0];
								for(int i=1; i<nums;i++) { 
												if( max_num < num_array[i] ) 
																max_num = num_array[i];
								}

								long[] M = new long[max_num+1];
								for(int i=0; i<max_num+1;i++) 
												M[i] = 0;

								for(int i=0; i<nums;i++) { 
												long sum = calcSum(num_array[i],M); 
												sb.append(sum+"\n");
								}
								System.out.println(sb.toString());
				}
 * */


/*
 * 교수님 예제 4
 * G(n)을 메모이제이션으로 활용
 * public static long calcSumDivisor(int n, long []M) {

								// int[] arr = {1,2,3,4,5,6,...n};
								// 해당하는 수의 약수의 합이 담긴 배열이 있다고 생각 -> all 1이라고 초기화
								if(M[n] != 0) return M[n];
								if ( n == 1 ) return 1;

								long ret = 1 + n;


								for(int i = 2; i <= n/2; i++ ) {
												if ( n % i == 0 ) // 안나눠지는 것도 불필요하게 연산함 n을 기준으로 나눠떨어지는지 생각 X 배수의 입장에서 생각
																ret = ret + i;
								}
								M[n] = ret;
								return M[n];
				}

				public static long calcSum(int n, long []M, long []M2) {
								if(M2[n] != 0) return M2[n];
								if(n==1) return 1;
								M2[n] = calcSum(n-1,M,M2) + calcSumDivisor(n,M);
								return M2[n];
				}

	
				public static void main(String[] args) throws NumberFormatException, IOException {
								BufferedReader bf;
								StringBuilder sb = new StringBuilder();
								int nums;
								int num_array[];
								int max_num;

								bf = new BufferedReader(new InputStreamReader(System.in));
								nums = Integer.parseInt(bf.readLine());
								num_array = new int[nums];
								for(int i=0; i<nums;i++) {
												num_array[i] = Integer.parseInt(bf.readLine());
								}

								max_num = num_array[0];
								for(int i=1; i<nums;i++) { 
												if( max_num < num_array[i] ) 
																max_num = num_array[i];
								}

								long[] M = new long[max_num+1];
								long[] M2 = new long[max_num+1];
								for(int i=0; i<max_num+1;i++) {
												M[i] = 0;
												M2[i] = 0;
								}

								for(int i=0; i<nums;i++) { 
												long sum = calcSum(num_array[i],M,M2); 
												sb.append(sum+"\n");
								}
								System.out.println(sb.toString());
				}
 * */
	