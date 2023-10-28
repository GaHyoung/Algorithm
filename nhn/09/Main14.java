//0921(목) -> 버블정렬

import java.util.Arrays;

public class Main14 {
    enum OrderType {ASC, DESC}

    public static Integer[] solution(Integer[] arr, OrderType orderType) {

        if(orderType == OrderType.ASC){ //오름차순
            for(int i = 0; i < arr.length -1; i++){ //i와 j는 다음인덱스를 비교하므로 범위를 벗어나지 않게 -1필요
                for(int j = 0; j < arr.length - i - 1 ; j++){
                    if(arr[j] > arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        
        }else{ //내림차순
            for(int i = 0; i < arr.length -1 ; i++){
                for(int j = 0; j < arr.length - i - 1 ; j++){
                    if(arr[j] < arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }

        return  arr;

    }

    public static void main(String[] args) {
       
        Integer[] unsortedArray1 = {5, 7, 2, 9, 10, 6, 1, 3, 4, 8};
        Integer[] unsortedArray2 = {6, 1, 3, 4, 8, 5, 7, 2, 9, 10};

        System.out.println("정렬 전: " + Arrays.toString(unsortedArray1));
        Integer[] ascSortedArray = solution(unsortedArray1, OrderType.ASC);
        System.out.println("정렬 후: " + Arrays.toString(ascSortedArray));


        System.out.println("정렬 전: " + Arrays.toString(unsortedArray2));
        Integer[] descSortedArray = solution(unsortedArray2, OrderType.DESC);
        System.out.println("정렬 후: " + Arrays.toString(descSortedArray));

    }
}
