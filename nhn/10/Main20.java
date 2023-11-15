//1005(목) -> 병합정렬. 분할정복 알고리즘
import java.util.Arrays;

public class Main20 {

    public static String solution(String input) {
        String[] str = input.split("");
        int[] numArr = new int [str.length];

        for(int i = 0; i < str.length; i++){
            numArr[i] = Integer.valueOf(str[i]);
        }

        numArr = mergeSort(numArr);
        StringBuilder result = new StringBuilder();

        for (int num : numArr) {
            result.append(num);
        }
        return result.toString();
    }


    public static int[] mergeSort(int[] numArr){
        int[] left = Arrays.copyOfRange(numArr, 0, numArr.length / 2);
        int[] right = Arrays.copyOfRange(numArr, numArr.length / 2, numArr.length);
        
        if(numArr.length > 1){
            left = mergeSort(left);
            right = mergeSort(right);
            return merge(left, right);
        }
        return numArr; //length가 1이 되는 순간 return. 그전까지는 계속 temp반환
    }

    public static int[] merge(int[] left, int[] right){
        int leftIndex = 0; //왼쪽 분할 배열 첫번째 인덱스
        int rightIndex = 0; //오른쪽 분할 배열 첫번째 인덱스

        int[] tempArr = new int[left.length + right.length];
        int tempIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if(left[leftIndex] > right[rightIndex]){
                tempArr[tempIndex] = right[rightIndex];
                rightIndex++;
            }else{
                tempArr[tempIndex] = left[leftIndex];
                leftIndex++;
            }
            tempIndex++;
        }

        //왼쪽 배열이 남는 경우
        while(leftIndex < left.length){
            tempArr[tempIndex++] = left[leftIndex++];
        }

        //오른쪽 배열이 남는 경우
        while(rightIndex < right.length){
            tempArr[tempIndex++] = right[rightIndex++];
        }

        return tempArr;
    }

    public static void main(String[] args) {
        String result = solution("759618324");
        System.out.println(result);
    }
}
