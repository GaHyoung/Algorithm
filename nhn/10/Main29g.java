//1020(금) -> general -> stack을 이용한 문자열 뒤집기
import java.util.Stack;

public class Main29g {
    public static String reverse(String str){
        //todo 1.stack을 이용한 문자열 뒤집기 구현.
        //str의 범위는 0 < str <=100 입니다.
        
        if(str.length() > 100 || str.length() < 0){
            throw new IllegalArgumentException();
        }

        String[] strArr = str.split("");
        int top = str.length();
        Stack stack = new Stack<>();
        
        
        for(int i = 0; i < str.length(); i++){
            stack.push(strArr[i]);
        }

        StringBuilder popValueBuilder = new StringBuilder();
        String popValue = "";

        while (top > 0) {
            popValue = stack.pop().toString();
            popValueBuilder.append(popValue);
            top--;
        }
        return popValueBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "abcd-efg";
        Main29g solution = new Main29g();
        String result = solution.reverse(str);
        
        System.out.println(result);
    }
}