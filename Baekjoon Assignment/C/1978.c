#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int is_no_division(int n) {
	int flag = 1;

	if (n == 1)
		return 0;

	for (int j = 2; j < n; j++) {
		if (n % j == 0)
			flag = 0;
	}
	return flag;
}
int main(void) {
	int n, i, j;
	int total = 0;

	scanf_s("%d", &n);

	int* data = (int*)malloc(sizeof(int) * n);

	for (i = 0; i < n; i++)
		scanf_s("%d", &data[i]);

	for (i = 0; i < n; i++) {
		if (is_no_division(data[i]) == 1)
			total++;
	}
	printf("%d\n", total);
}