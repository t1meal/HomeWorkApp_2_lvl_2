import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String correctArr [][] = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}};

        String wrongArr [][] = {
                {"1","2","!","4"},
                {"5","6","7","8"},
                {"9","10","11","12"}};

        int sndArr [][] = new int[4][4];

        try {
            entArray(correctArr, sndArr);
        } catch (MyArrayDataException c){
            System.out.println("Ошибка данных массива!");
            c.printStackTrace();
        } catch (MyArraySizeException b){
            System.out.println("Ошибка размера массива!");
            b.printStackTrace();
        } catch (Exception e){
            System.out.println("Общая ошибка!");
            e.printStackTrace();
        }

    }
    public static void entArray (String [][] frsArr, int [][] sndArr) throws MyArraySizeException, MyArrayDataException {

        String [][] checkArr = new String[4][4];
        if (frsArr.length != checkArr.length){
            throw new MyArraySizeException("Размер массива отличается от 4х4");
        }

        int sumArr = 0;

        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                sndArr[i][j] = Integer.parseInt(frsArr[i][j]);
                sumArr += sndArr[i][j];
                System.out.println("Итерация");
                throw new MyArrayDataException("В ячейке массива лежат неверные данные!");
            }
        }
        System.out.println(Arrays.deepToString(sndArr));
        System.out.println(sumArr);
    }


}
