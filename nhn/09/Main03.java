//0906(수) -> 2진수 -> 10진수 변환
public class Main03 {
    private static final String[] TEST_CASE_KEYS = {
        "00000001",
        "101",
        "1011",
        "111000",
        "1011111",
        "1111111111111",
        "00111001110001111100001"
};

private static final int[] TEST_CASE_VALUES = {
        1,
        5,
        11,
        56,
        95,
        8191,
        1893345
};

private static double correct = 0;

public static void main(String[] args) {
    for (int i = 0; i < TEST_CASE_KEYS.length; i++) {
        System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASE_KEYS[i], TEST_CASE_VALUES[i]));
    }

    System.out.printf("정답률 = %.3f%%", (correct / TEST_CASE_KEYS.length * 100));
}

private static boolean test(String input, Integer result) {
    if (solution(input) == result) {
        correct++;
        return true;
    }
    return false;
}

public static int solution(String input){

    char[] array = input.toCharArray();
    int result = 0;

    for(int i = 0 ; i < array.length ; i++){ //문자의 처음[0]부터 비교
        char chr = array[i];
        int pow = array.length - 1 - i;

        if(chr == '1'){ //char는 ''로 값을 표현해야한다.
            result += (int)Math.pow(2, pow); //2~0
            //pow를 여기서 감소하면 if문을 빠져나가면서 pow값이 기존값으로 돌아간다.
        }
    }
    return result;
}
}
