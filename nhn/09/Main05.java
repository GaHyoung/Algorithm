//0908(금) -> 수 뒤집기 -> 수를 뒤집어 덧셈을 수행한 후, 더한 수를 다시 뒤집기
public class Main05 {
    private static double correctCount = 0;

    private static final String[][] TESTCASES = new String[][] {
            {"123", "123", "246"},
            {"1000", "1", "2"},
            {"456", "789", "1461"},
            {"5", "5", "1"},
            {"11112", "54321", "65433"},
            {"3829", "1300", "4139"}
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2]));

        System.out.println("정답률 = " + (int) (correctCount / TESTCASES.length * 100) + "%");
    }

    private static boolean test(String input, String input2, String answer) {
        int first = Integer.parseInt(input);
        int second = Integer.parseInt(input2);

        boolean res = String.valueOf(solution(first, second)).equals(answer);
        if (res)
            correctCount++;
        return res;
    }

    public static int solution(int first, int second){

        int result1 = 0;
        int result2 = 0;

        while(first !=0 || second !=0){
            if(first != 0){
                int reverseFirst = first % 10; //나머지 3 //나머지 2 //나머지 1
                result1 = (result1*10) + reverseFirst; //3 //32 //321
                first = first / 10; //12 //1 //0

            }else {
                int reverseSecond = second % 10;
                result2 = (result2*10) + reverseSecond;
                second = second / 10;
            }
        }

        int sum = result1 + result2;
        int finalResult = 0;

        while(sum != 0){
            int reverseSum = sum % 10;
            finalResult = (finalResult*10) + reverseSum;
            sum = sum / 10;
        }

        return finalResult;
    }
    
}
