#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void is_one(long long n) {
	int count = 0;
	long long m = 1;

	while (m % n != 0) {
		m = m % n;
		m = 10 * m + 1;
		count++;
	}

	printf("%d\n", count+1);
}

int main() {
	long long n;

	// 입력은 여러 개의 테스트 케이스가 가능하므로 종료조건을 EOF로 준다
	while (scanf("%lld", &n) != EOF) 
		is_one(n);

	return 0;
}