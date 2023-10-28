//0918(월) -> 기약분수 만들기
public class Main11 {
    public static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;

            normalize(); //약분 메서드를 불러온다.
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        // 약분 하기 -> 두 수를 최대 공약수로 나누기
        public void normalize() {
            
            int result = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator = numerator / result;
            denominator = denominator / result;
            
        }

        // 최대 공약수 구하기
        public int gcd(int first, int second) {
            
            int r = 0;

            while(second != 0){
                r = first % second;
                first = second;
                second = r;
            }

            return first;
        }

        // 분수 형태로 만들기 -> "/"가 있어야한다. 음수값인 경우를 유의해야한다.
        @Override
        public String toString() {

            String result = "";
            //둘의 값을 곱했을 때 음수이면 -
            //수가 커질 경우 int 범위를 벗어날 경우를 대비해 절댓값으로 나눠준 후 부호만 계산한다.
            if(getNumerator()/Math.abs(getNumerator()) * getDenominator()/Math.abs(getDenominator()) < 0){
                result = "-";
            }
            
            return result + Math.abs(getNumerator()) + "/" + Math.abs(getDenominator());

        }
    }

    public static String solution(int numerator, int denominator) {
        
        Fraction fraction = new Fraction(numerator, denominator);
        
        return fraction.toString();
    }


    //Test
    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println(
                    "Test Case " + (i + 1) + " = " + test(TEST_CASES[i][0], TEST_CASES[i][1], Test_CASES_RESULT[i]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }

    private static double correct = 0;

    private static boolean test(int numerator, int denominator, String result) {
        if (solution(numerator, denominator).equals(result)) {
            correct++;
            return true;
        }

        return false;
    }

    private static final int[][] TEST_CASES = { { 1, 4 }, { -10, 20 }, { 10, -20 }, { -5, -10 }, { 7, 39 },
            { 100, 100 }, { 369, 444 }, { 1_000_000, 1_998_244_353 }, { 1_234_567, 999_999_937 } };

    private static String[] Test_CASES_RESULT = { "1/4", "-1/2", "-1/2", "1/2", "7/39", "1/1", "123/148",
            "1000000/1998244353", "1234567/999999937" };

}

