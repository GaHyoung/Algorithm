//0914(목) -> 최대공약수 구하기2 (BigInteger 사용)
import java.math.BigInteger;

public class Main09_1 {
    private static int gcdThing(int a, int b) {
 
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        
        return gcd.intValue();
    }
    public static void main(String[] args) {
        int num1 = 36; // 첫 번째 정수 설정
        int num2 = 48; // 두 번째 정수 설정

        int result = gcdThing(num1, num2);
        System.out.println(num1 +", " + num2 + "의 최대공약수는 " + result);
    }
}
