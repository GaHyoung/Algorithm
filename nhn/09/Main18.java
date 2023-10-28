//0926(화) -> 삽입정렬
public class Main18 {
    public static String solution(String input) {

        String[] str = input.split("");
        int[] arr = new int[str.length];

        for(int i = 0 ; i < arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        //배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 자신의 위치를 찾아 삽입
        //1번 인덱스 기준, 앞(0번)인덱스와 값 비교
        //2번 인덱스 기준, 앞(0번, 1번)인덱스에 올바른 위치 찾아가기

        for(int i = 1; i < arr.length; i++){
            int index = i-1;
            int temp = arr[i];

            while((index >= 0) && (temp < arr[index])){
                arr[index+1] = arr[index]; //앞의 값(큰 수)을 뒤에 덮어줌
                index--;
            }
            arr[index+1] = temp; //저장해뒀던 작은 값을 앞에 넣어준다.
        }

        String result = "";
        for(int n : arr){
            result += String.valueOf(n);
        }
        return result;

    }

    public static void main(String[] args) {

        String input1 = "759618324";
        String input2 = "53950971392";
        String sortedArray1 = solution(input1);
        String sortedArray2 = solution(input2);

        System.out.println(String.format("정렬 전 : %s, 정렬 후 : %s", input1, sortedArray1));
        System.out.println(String.format("정렬 전 : %s, 정렬 후 : %s", input2, sortedArray2));
       
    }
}
