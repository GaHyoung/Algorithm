//0919(화) -> factorial, fibonacci
public class Main12 {

    public static long factorial(int number) {
        
        switch(number){
            case 0:
            case 1:
                return 1;
            default:
                return number * factorial(number-1);
        }
    }

    public static long fibonacci(int number) {
        
        switch(number){
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibonacci(number-1) + fibonacci(number-2);
        }
    }

    public static void main(String[] args) {
        System.out.println("factorial(5) = " + factorial(5));
        System.out.println("factorial(6) = " + factorial(6));

        System.out.println("fibonacci(10) = " + fibonacci(10));
        System.out.println("fibonacci(12) = " + fibonacci(12));
    }
}

