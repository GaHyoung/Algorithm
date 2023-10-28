//0912(화) -> 특정 범위 내의 소수의 개수 구하기
public class Main07 {

    // 소수의 정의 : 1과 자기 자신만을 약수로 가지는 수
    // => 자기 자신과 1을 제외하고는 나누었을때 나머지가 0이면 안된다.

    public static void main(String[] args) {
        
        boolean isPrimeNumber = false;
        int start = 10;
        int end = 20;
        int count = 0;

        for(int i = start; i < end; i++){
            if(i == 2){ //i가 2일때 따로 처리
                isPrimeNumber = true;
            }
            for(int j = 2; j < i; j++){ //i는 1일때 j보다 작으니 돌아가지 않음. i가 3일때부터 진행됨.
                if(i % j == 0){
                    isPrimeNumber = false;
                    break;
                }else{
                    isPrimeNumber = true;
                }
            }
            if(isPrimeNumber){
                System.out.println(i + "는 소수 입니다.");
                count++;
            }
        }
        System.out.println(String.format("%d부터 %d까지 소수의 개수는 %d개 입니다.", start, end, count));
        
    }
    
}
