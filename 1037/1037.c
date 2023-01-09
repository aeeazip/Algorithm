#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int find_min(int* divisor, int count) {
	int min = divisor[0];
	int i;

	for (i = 0; i < count; i++) {
		if (divisor[i] < min)
			min = divisor[i];
	}
	return min;
}

int find_max(int* divisor, int count) {
	int max = divisor[0];
	int i;

	for (i = 0; i < count; i++) {
		if (divisor[i] > max)
			max = divisor[i];
	}
	return max;
}

int main(void) {
	int count, i = 0; // 약수 개수
	int min, max;
	int divisor[50];

	scanf_s("%d", &count);
	for (i = 0; i < count; i++)
		scanf_s("%d", &divisor[i]);

	min = find_min(divisor, count);
	max = find_max(divisor, count);
	printf("%d", min*max);
}