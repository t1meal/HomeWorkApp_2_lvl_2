import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String frsArr [][] = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}};

        String thirdArr [][] = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"}};

        int sndArr [][] = new int[4][4];

        try {
            entArray(thirdArr, sndArr);
        } catch (MyArraySizeException b){
            System.out.println("Другой размер массива");;
        } catch (MyArrayDataException c){
            c.printStackTrace();
        } catch (Exception e){
            System.out.println("Общая ошибка");
        }

    }
    public static void entArray (String [][] frsArr, int [][] sndArr) throws MyArraySizeException, MyArrayDataException {
        int sumArr = 0;
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                sndArr[i][j] = Integer.parseInt(frsArr[i][j]);
                sumArr += sndArr[i][j];
            }
        }
        System.out.println(Arrays.deepToString(sndArr));
        System.out.println(sumArr);
    }


}
