//  N이하의 자연수를 i라고 하면, i 들은 g(N)안에 (N /  i) * i 만큼 들어있다는 규칙을 발견할 수 있다. 
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


int main(void) {
	int n;
	long long total = 0;

	scanf_s("%d", &n);

	for (int i = 1; i <= n; i++) 
		total += (n / i) * i;
	
	printf("%lld", total);
}
