//0922(금) -> 버블정렬2 -> 정렬 과정에서 얼마나 많은 요소가 이동하는지를 측정
public class Main15 {

    public static int solution(int[] unsortedArray, int[] sortedArray) {

        //가장 많이 이동한 수가 버블정렬의 횟수이다.
        int maxDistance = 0;
        for(int i = 0; i < sortedArray.length; i++){
            for(int j = 0; j < unsortedArray.length; j++){
                if(sortedArray[i] == unsortedArray[j]){ //ex) 12357, 15273
                    if(j-i > maxDistance){
                        maxDistance = j-i;
                    }
                }
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int[] unsortedArray = {42, 17, 8, 64, 23, 91, 55, 3, 36, 70};
        int[] sortedArray = {3, 8, 17, 23, 36, 42, 55, 64, 70, 91};
        int[] unsortedArray2 = {49, 63, 31, 72, 99, 83, 45, 57, 26, 37};
        int[] sortedArray2 = {99, 83, 72, 63, 57, 49, 45, 37, 31, 26};
        

        int maxDistance = solution(unsortedArray, sortedArray);
        int maxDistance2 = solution(unsortedArray2, sortedArray2);
    
        System.out.println("Max distance: " + maxDistance);
        System.out.println("Max distance2: " + maxDistance2);
    }

}