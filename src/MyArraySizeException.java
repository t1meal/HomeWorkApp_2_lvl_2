public class MyArraySizeException extends Exception {
    int checkArr[][] = new int[4][4];

    MyArraySizeException(int arr [][]){
        if(arr.length == checkArr.length){
            return;
        } else{
            System.out.println("Неправильный размер массива");
        }
    }
}
