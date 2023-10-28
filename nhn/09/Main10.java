//0915(금) -> 최소공배수 구하기 -> 유클리드 호제법을 이용해 계산
public class Main10 {
    public static void main(String[] args) {
        
        int first = 12;
        int second = 16;

        int a = first;
        int b = second;

        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }

        //최소공배수 = 두수의 곱 / 최대공약수
        int result = (first * second) / a;

        System.out.println("최소공배수는 " + result);

    }
}

