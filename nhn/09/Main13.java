//0920(수) -> 문자열 뒤집기
public class Main13 {
    public static void solution(char[] input) {

        //1. input배열 자체에서 값을 교환
        for(int i = 0, j = input.length-1; i < input.length && i <= j; i++, j--){
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;

        }

        //2. 뒤집은 배열 arr 생성해서 값 복붙 input배열 자체에서 값을 교환해야함.
        // char[] arr = new char[input.length];
        // int index = input.length-1;
        // for(int i = 0; i < input.length; i++){
        //     arr[index] = input[i]; //input 0번인덱스는 arr의 마지막 인덱스로
        //     index--;
        // }
        // for (int i = 0; i < input.length; i++) {
        //     input[i] = arr[i];
        // }
    }

    public static void main(String[] args) {
        char[] input1 = "Hello".toCharArray();
        char[] input2 = "Computer".toCharArray();
        char[] input3 = "Chocolate".toCharArray();

        Main13.solution(input1);
        Main13.solution(input2);
        Main13.solution(input3);

        System.out.println("Reversed input1: " + new String(input1));
        System.out.println("Reversed input2: " + new String(input2));
        System.out.println("Reversed input3: " + new String(input3));

    }
}
