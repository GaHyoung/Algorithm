//0905(화) -> 10진수 -> 2진수로 변환
public class Main02 {

    public static void main(String[] args) {
        int[] input = { 0, 3, 2, 624, 339, 13, 45232 };
        String[] output = { "0", "11", "10", "1001110000", "101010011", "1101", "1011000010110000" };

        System.out.printf("Out of %d Cases, %1.0f were correct", input.length, test(input, output));
    }

    public static double test(int[] input, String[] output) {
        double score = 0;

        for (int i = 0; i < input.length; i++) {
            System.out.printf("Case %d %n", i);

            String correct = output[i];
            System.out.printf("Input : %d \t -> Expected : %s %n", input[i], output[i]);

            String str = solution(input[i]);
            System.out.printf("Your Answer : %s %n", str);

            if (str.equals(correct)) {
                score++;
            }
        }

        return score;
    }

    /**
     * 
     * @param input 테스트 할 코드입니다.
     * @return
     */


    public static String solution(int input) {
        
        //input은 몫. 0보다 커야함. 0인 경우도 있으므로 한 번은 돌 수 있게 do-while로 처리.
        //2진수 -> 나머지. String으로 받아야함.

        String result = "";

        do {
            result = (input % 2) + result;
            input /= 2;

        } while (input > 0);

        return result;
    }
}

