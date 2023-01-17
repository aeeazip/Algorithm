// 에라토스테네스의 체 활용

#include <stdio.h>
#include <stdbool.h>

int main(void) {
	int a, b;
	int arr[1000001] = {0};
	scanf_s("%d %d", &a, &b);

	for (int i = 2; i <= b; i++) 
		arr[i] = i;

	for (int i = 2; i * i <= b; i++) {
		if (arr[i] == 0)
			continue;
		
		for (int j = i * 2; j <= b; j += i) 
			arr[j] = 0;
	}

	for (int i = a; i <= b; i++) {
		if (arr[i] != 0)
			printf("%d\n", i);
	}
	
	return 0;
}