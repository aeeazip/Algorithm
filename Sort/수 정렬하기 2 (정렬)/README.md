| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞힌 사람 | 정답 비율 |
| --- | --- | --- | --- | --- | --- |
| 2 초 | 256 MB | 244465 | 71235 | 49700 | 30.638% |

## 문제

N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

## 입력

첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 

둘째 줄부터 N개의 줄에는 수가 주어진다. 

이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 

수는 중복되지 않는다.

## 출력

첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

## 예제 입력 1

```
5
5
4
3
2
1
```

## 예제 출력 1

```
1
2
3
4
5
```

## 문제풀이

입력값을 list에 저장하고 내장함수인 Collections.sort() 함수를 사용했다.

Scanner로 원소를 입력받았을때 시간 초과가 발생해서 BufferedReader를 사용해보았으나 마찬가지로 시간초과가 발생했다.

입력이 아니라 출력에서 시간 초과가 발생함을 깨달았고, 버퍼에 출력값을 담았다가 flush 해주면서 한 번에 출력해주었더니 시간 초과를 해결할 수 있었다. 


또한 Arrays.sort()를 썼다면 시간 초과가 발생할 수 있었는데 Collections.sort()를 사용해서 시간 초과를 방지하였다. 

|  | 정렬 방식 | 시간 복잡도 |
| --- | --- | --- |
| Arrays.sort() | DualPivotQuickSort | 평균 : O(nlog(n)) / 최악 : O(n^2) |
| Collections.sort() | TimeSort(삽입정렬 + 합병정렬) | 평균, 최악 : O(nlog(n)) |

Collections.sort()는 최악의 경우에도 O(nlog(n))의 시간 복잡도를 보장하기 때문에 특별한 제약이 없는 경우

Collections.sort()를 사용하는게 좋다.