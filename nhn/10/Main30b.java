//1023(월) -> basic -> 배열에서 큰 수, 작은 수 구하기
public class Main30b {
    public static double getLargestNumber(double[] arr) {
        if(arr.length == 0){
            throw new IllegalArgumentException();
        }

        double max = arr[0];
        for(int i = 0 ; i < arr.length - 1; i++){
            if(max < arr[i+1]){
                max = arr[i+1];
            }
        }
        return max;
    }

    public static double getSmallestNumber(double[] arr) {
        if(arr.length == 0){
            throw new IllegalArgumentException();
        }

        double min = arr[0];
        for(int i = 0 ; i < arr.length - 1; i++){
            if(min > arr[i+1]){
                min = arr[i+1];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        double[] arr = {3, 1, 5, 7, 6, 9};
        System.out.println("max : " + getLargestNumber(arr));
        System.out.println("min : " + getSmallestNumber(arr));
    }
}
