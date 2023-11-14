//1004(수) -> 삽입정렬. 정렬된 위치 Index 찾기
public class Main19 {

    static int[] sortedArray;

    public static int add(int intValue) {
        int[] tempArray = new int[sortedArray.length + 1];

        for (int i = 0; i < sortedArray.length; i++) {
            tempArray[i] = sortedArray[i];
        }

        tempArray[tempArray.length - 1] = intValue;
        sortedArray = tempArray;

        //저장되는 index값을 반환
        int insertedIndex = solution(sortedArray);

        return insertedIndex;
    }

    public static int solution(int[] sortedArray) {

        int index = sortedArray.length - 1; //4번
        int temp = 0; 

        for(int i = sortedArray.length - 2; i >= 0 ; i--){
            if(sortedArray[index] < sortedArray[i]){
                //현재 삽입된 [i]가 이미 정렬되어있는 [index]보다 크다면
                temp = sortedArray[i];
                sortedArray[i] = sortedArray[index];
                sortedArray[index] = temp;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] initialArray = {5, 2, 7, 1, 8, 3, 6, 9};
        sortedArray = new int[0];
    
        System.out.print("Index : ");
        for (int intValue : initialArray) {
            System.out.print(add(intValue) + " ");
        }                                               
    
        // 변경된 배열 출력
        System.out.print("Sorted Array: ");
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}