//0914(목) -> 최대공약수 구하기
public class Main09 {
  public static void main(String[] args) {

    int i = 16;
    int j = 12;

    while(j != 0){
        int r = i % j; //나머지를 저장. 나머지가 0이면 종료. 나누는 수가 나눠지는 수보다 클 경우 나누는 수가 나머지가 되어서 위치가 뒤바뀜.
        i = j; //나누는 수 저장
        j = r; //나머지를 다시 나누도록 j에 저장.
    }
    
    // return i; //i로 나누었을 때 나누어 떨어졌으므로 최대공약수
    System.out.println("최대공약수는 " + i);

  }

}

