//0926(화) -> 선택정렬 심화
public class Main17 {
    public static void solution(int[] unsortedArray) {

    int minIndex = 0;

    for(int i = 0; i < unsortedArray.length; i++){

        if(i%2 == 0){ //작은 수를 앞으로 보내는 경우
            minIndex = i/2;
            for(int j = (i/2) ; j < unsortedArray.length - (i/2); j++){
                if(unsortedArray[minIndex] > unsortedArray[j]){
                    minIndex = j;
                }
            }
            int temp = unsortedArray[i/2];
            unsortedArray[i/2] = unsortedArray[minIndex];
            unsortedArray[minIndex] = temp;

        }else{ //작은 수를 뒤로 보내는 경우
            //배열의 끝부터 자리 결정된 수 제외한 가장 작은수를 찾아 뒤로 보냄
            minIndex = (i+1)/2;
            for(int j = unsortedArray.length - (i+1)/2; j > (i+1)/2 ; j--){
                if(unsortedArray[minIndex] > unsortedArray[j]){
                    minIndex = j;
                }
            }
            int temp = unsortedArray[unsortedArray.length - (i+1)/2];
            unsortedArray[unsortedArray.length - (i+1)/2] = unsortedArray[minIndex];
            unsortedArray[minIndex] = temp;

        }
    }
    }

    public static void main(String[] args) {
        int[] unsortedArray1 = {5, 9, 2, 4, 7};
        int[] unsortedArray2 = {10, 9, 7, 4, 2, 1, 3};
        solution(unsortedArray1);
        solution(unsortedArray2);

        for (int num : unsortedArray1) {
            System.out.print(num + " ");
        }
        System.out.println("");
        for (int num : unsortedArray2) {
            System.out.print(num + " ");
        }
        
    }

}
