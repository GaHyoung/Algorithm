//0914(목) -> 최대소공배수 구하기2 (BigInteger 사용)
import java.math.BigInteger;

public class Main10_1 {
    public static int gcdThing(int a, int b){
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);

        return gcd.intValue();

    }
    public static void main(String[] args) {

        int num1 = 24;
        int num2 = 15;

        int gcd = gcdThing(num1, num2); //최대공약수
        int lcm = (num1 * num2) / gcd;  //최소공배수 = 두수의 곱 / 최대공약수
    

        System.out.println(num1 +", " + num2 + "의 최대공약수는 " + gcd);
        System.out.println(num1 +", " + num2 + "의 최소공배수는 " + lcm);
    }
}
