| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞힌 사람 | 정답 비율 |
| --- | --- | --- | --- | --- | --- |
| 0.25 초 (추가 시간 없음) | 128 MB | 177737 | 51790 | 40623 | 31.934% |

## 문제

다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.

```
int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}
```

fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.

- fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.

- fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.

- 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.

- fibonacci(0)은 0을 출력하고, 0을 리턴한다.

- fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.

- 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.

- fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.

- 1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

## 입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

## 출력

각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

## 예제 입력 1

```
3
0
1
3
```

## 예제 출력 1

```
1 0
0 1
1 2
```

## 예제 입력 2

```
2
6
22
```

## 예제 출력 2

```
5 8
10946 17711
```

### 문제풀이
bottom-up 방식으로 문제를 풀기 위해 fib(n) 함수 호출 시 출력되는 0과 1의 개수를 담는 배열 M0, M1을 각각 만들었다.

Fib(0), Fib(1), Fib(2)는 항상 초기값으로 주어지기 때문에 

### Fib(0)
| M0[0] | M1[0] |
| --- | --- |
| 1 | 0 |

### Fib(1)
| M0[1] | M1[1] |
| --- | --- |
| 0 | 1 |

### Fib(2)
| M0[2] | M1[2] |
| --- | --- |
| 1 | 1 |

(M0[2] = M0[1] + M0[0] = 1 / M1[2] = M1[1] + M1[0] = 1) 로 설정해준다.

### Fib(3) 이상
| M0[n] | M1[n] |
| --- | --- |
| M0[n-1] + M0[n-2] | M1[n-1] + M1[n-2] | 

피보나치 수열 함수의 관계를 활용하면 쉽게 문제를 풀 수 있으며, 배열의 크기가 0, 1, 2 보다 작은 경우를 대비한 예외처리가 추가적으로 필요하다. 

