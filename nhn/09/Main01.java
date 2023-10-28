//0904(월) -> 문자열의 대문자와 소문자를 반전
public class Main01 {
    private static double correctCount = 0;
    private static final String[][] TESTCASES = new String[][] {
        { "MANGO", "mango" }, 
        { "peach", "PEACH" },
        { "Apple", "aPPLE" }, 
        { "baNANa", "BAnanA" }, 
        { "Believe In YourSelF", "bELIEVE iN yOURsELf" }, 
        { "THiS is how LIFE is!!", "thIs IS HOW life IS!!" }, 
        { "Li^^ve  p$osi&TIVE*", "lI^^VE  P$OSI&tive*" }, 
        { "%tiMe~~~~ iS>.< gggggolD ?:)", "%TImE~~~~ Is>.< GGGGGOLd ?:)" }
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++) 
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1]));

        System.out.println("정답률 = " + (int)(correctCount / 8 * 100) + "%");
    }

    private static boolean test(String input, String answer) {
        boolean res = solution(input).equals(answer);
        if (res)
            correctCount++;
        return res;
    }


    // solution
    public static String solution(String input) {
        
        //'char'의 형태로 나타낼 수 있는 방법은 유니코드, ASCII코드, 문자
        char[] array = input.toCharArray();

        for(int i = 0; i < array.length; i++){
            if(array[i] >= 65 && array[i]<= 90){
                array[i] += 32;
            }else if(array[i] >= 97 && array[i] <=122 ){
                array[i] -= 32;
            }
        }

        //Object가 null인 경우 toString90은 NullPointerException 발생
        //valueOf()는 null이라는 문자열로 처리
        return String.valueOf(array);
    }
}