//0925(월) -> 선택정렬
public class Main16 {
    
    public static String solution(String input) {

        //값 비교를 위해 String을 쪼개서 int배열에 넣기
        String[] str = input.split("");
        int[] arr = new int[str.length];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        for(int i = 0 ; i < arr.length; i++){
            int minNum = arr[i];
            int minIndex = i;

            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < minNum){
                    minNum = arr[j];
                    minIndex = j;
                }
            }
            //작은 수의 위치인 j는 for문밖에서 쓰지 못하므로 minIndex 사용
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }

        String result = "";
        for(int n : arr){
            result += String.valueOf(n);
        }

        return result;

    }

    public static void main(String[] args) {
        // solution("572961348");
        String input1 = "572961348";
        String input2 = "83014729";
        System.out.println("정렬 전 : " + input1);
        System.out.println("정렬 후 : " + solution(input1));
        System.out.println("정렬 전 : " + input2);
        System.out.println("정렬 후 : " + solution(input2));
    }
}
