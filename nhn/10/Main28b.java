//1019(목) -> basic -> 배열을 이용한 평균 계산
public class Main28b {

    public static double averageReturnDouble(double arr[]){
        // TODO 1.arr[]의 average(평균값 계산하기) 소숫점 2자리 까지 반올림 하여 반환

        if(arr.length == 0){
            throw new IllegalArgumentException();
        }

        double result = 0;
        for(int i = 0; i < arr.length; i++){
            result += arr[i];
        }
        result /= arr.length;
        
        return Math.round(result*100)/100.0;
    }

    public static String averageReturnString(double... arr){
        // TODO 2.arr[]의 average(평균값 계산하기) - 소숫점 2자리 까지 반올림 하여 반환

        double result = 0;
        for(int i = 0; i < arr.length; i++){
            result += arr[i];
        }
        result /= arr.length;
        
        return String.valueOf(Math.round(result*100)/100.0);
    }

}

