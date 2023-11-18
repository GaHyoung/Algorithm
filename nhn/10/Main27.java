//1018(수) -> 배열의 연속되는 최대 구간 합, maxSubarraySum
//최대 합계를 갖는 연속되는 하위 배열을 찾아 합계를 구해 반환
public class Main27 {
    public static long maxSubarraySum(int arr[]){

        int currentSum = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i < arr.length; i++){
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, -2, 5};
        long result1 = Main27.maxSubarraySum(arr1);
        System.out.println("Test1: " + result1);

        int[] arr2 = {-1, -2, -3, -4};
        long result2 = Main27.maxSubarraySum(arr2);
        System.out.println("Test2: " + result2);

        int[] arr3 = {-2, -3, 4, -1, -2, 1, 5, -3};
        long result3 = Main27.maxSubarraySum(arr3);
        System.out.println("Test3: " + result3);
    }
}

