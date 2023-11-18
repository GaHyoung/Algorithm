//1020(금) -> basic -> 표준편차
public class Main29b {

    public static double calcStandardDeviation(double[] arr){
        //todo 1 표준편차 계산
        //각 자료마다 평균으로부터 떨어진 거리를 제곱한 값을 더한다.
        //자료점의 개수로 나눈 후 제곱근을 구한다.

        double avg = 0;
        double deviationSum = 0;
        double standardDeviation = 0;

        if(arr.length == 0){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < arr.length ; i++){
            avg += arr[i] / arr.length;
        }
     
        for(int i = 0; i < arr.length; i++){
            deviationSum += Math.pow(arr[i]-avg, 2);
            standardDeviation = Math.sqrt(deviationSum / arr.length);
        }

        return standardDeviation;
    }

    public static void main(String[] args) {
        Main29b solution = new Main29b();
        double[] arr = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double result = solution.calcStandardDeviation(arr);

        System.out.println(result);
    }

}
