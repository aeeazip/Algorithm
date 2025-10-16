class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            String binaryNum = calc(numbers[i], "");
            binaryNum = makeFullBinaryTree(binaryNum);
            boolean result = check(binaryNum.split(""), 0, binaryNum.length() - 1);
            answer[i] = result ? 1 : 0;
        }
        
        return answer;
    }
    
    // 이진수 만들기
    public static String calc(long N, String s) {
        if(N == 1 || N == 0) return String.valueOf(N);
        
        s += calc(N / 2, s);
        s += N % 2;
        
        return s;
    }
    
    // 포화이진트리 문자열로 만들기
    public static String makeFullBinaryTree(String num) {
        int nodes = 1;
        while(nodes < num.length()) {
            nodes = nodes * 2 + 1;
        }
        
        // nodes - num.length() 만큼 num 앞에 0붙이기
        String result = "";
        for(int i = 0; i < nodes - num.length(); i++) 
            result += "0";
        
        return result + num;     
    }
    
    public static boolean check(String[] num, int left, int right) {
        if(left > right) return true;
        
        int mid = (left + right) / 2;
        String root = num[mid]; // 루트     

        if(root.equals("0")) {
            // 왼쪽 자식
            if(left <= mid - 1) {
                int leftMid = (left + mid - 1) / 2; // 왼쪽 자식 루트
                if(num[leftMid].equals("1")) return false;
            }
            
            // 오른쪽 자식
            if(mid + 1 <= right) {
                int rightMid = (mid + 1 + right) / 2; // 오른쪽 자식 루트
                if(num[rightMid].equals("1")) return false;
            }
        }
        
        return check(num, left, mid - 1) && check(num, mid + 1, right);
        
    }
}