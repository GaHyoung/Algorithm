//0911(월) -> 문자열 속 특정 문자열 개수 세기
public class Main06 {
    private static double correctCount = 0;
    private static final String[][] TESTCASES = new String[][] {
            { "abciwkabc", "abc", "2" },
            { "aciwcosck", "c", "3" },
            { "banana", "na", "2" },
            { "alhorithmtest", "th", "1"},
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2]));

        System.out.println("정답률 = " + (int)(correctCount / TESTCASES.length * 100) + "%");
    }

    private static boolean test(String input, String input2, String answer) {
        boolean res = String.valueOf(solution(input, input2)).equals(answer);
        if (res)
            correctCount++;
        return res;
    }


    private static int solution(String input, String input2) {
        //replace 함수 : 자신이 바꾸고싶은 문자로 문자열을 치환
        int count = 0;

        for(int i = 0; i < input.length(); i++){
            if(input.contains(input2)){
                input = input.replaceFirst(input2, "");
                count++;
            }
        }

        return count;
    }
}
