public class MyArrayDataException extends Exception {

    MyArrayDataException(int row, int col){
        super("Неверные данные находятся в ячейке " + row + "." + col);
    }
}
