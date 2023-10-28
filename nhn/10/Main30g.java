//1023(월) -> general -> Postfix 수식계산
import java.util.Stack;

public class Main30g {
    public static int evaluatePostFix(String str) {

        char[] charArr = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        //피연산자를 만나면 정수형으로 변환하여 스택에 넣는다.
        //연산자를 만나면 값을 두개 꺼내서 계산하고 결과값을 다시 스택에 넣는다.

        int a = 0;
        int b = 0;
        int result = 0;

        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == '+'){
                b = stack.pop();
                a = stack.pop();
                result = a + b;
                stack.push(result);

            }else if(charArr[i] == '-'){
                b = stack.pop();
                a = stack.pop();
                result = a - b;
                stack.push(result);

            }else if(charArr[i] == '*'){
                b = stack.pop();
                a = stack.pop();
                result = a * b;
                stack.push(result);

            }else if(charArr[i] == '/'){
                b = stack.pop();
                a = stack.pop();
                result = a / b;
                stack.push(result);

            }else{ // 숫자
                stack.push(charArr[i] - '0');
                //'0' 문자의 아스키 코드 값을 빼야 정수값으로 변환하여 스택에 넣음
            }
        }
        return result;
    }


    public static void main(String[] args) {

        Main30g calculator = new Main30g();

        String preOrder1 = "352*+9-";
        String preOrder2 = "652*+4/";

        int result1 = calculator.evaluatePostFix(preOrder1);
        int result2 = calculator.evaluatePostFix(preOrder2);

        System.out.println("352*+9 -> " + result1);
        System.out.println("652*+4/ -> " + result2);
        
    }
}
