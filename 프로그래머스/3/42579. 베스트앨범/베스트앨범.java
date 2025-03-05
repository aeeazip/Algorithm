import java.util.*;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>(); // 장르, 누적 재생 횟수
        for(int i = 0; i < genres.length; i++) {
            int count = map.get(genres[i]) == null ? plays[i] : map.get(genres[i]) + plays[i];
            map.put(genres[i], count);
        }

        // 해시맵 value 기준으로 내림차순 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < keySet.size(); i++) {
            // 1. 해당 장르에 속한 노래 인덱스와 재생 횟수 arr에 기록
            int k = 0;
            String genre = keySet.get(i);
            int len = (int) Arrays.stream(genres).filter(g -> g.equals(genre)).count();
            int[][] arr = new int[len][2];

            for(int j = 0; j < genres.length; j++) {
                if(genres[j].equals(genre)) {
                    arr[k][0] = j; // 인덱스
                    arr[k++][1] = plays[j]; // 재생 횟수
                }
            }

            // 2. arr 정렬 (재생횟수 기준 내림차순, 고유번호 오름차순 정렬)
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if(a[1] != b[1]) { // 재생횟수 다르면 재생횟수 기준 내림차순
                        return Integer.compare(b[1], a[1]);
                    }
                    return Integer.compare(a[0], b[0]); // 고유번호 기준 오름차순
                }
            });
            
            // 3. arr에 담긴 상위 2개 담기
            result.add(arr[0][0]);
            if(arr.length > 1) { // 장르에 속한 노래가 한 개 이상인 경우
                result.add(arr[1][0]);
            }
        }
        
        // 4. List<Integer> -> int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}