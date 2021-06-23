import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random1 = new Random();

        String correctArr1 [][] = new String[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                correctArr1[i][j] = String.valueOf(random1.nextInt(50));
            }
        }
        // массив с неверным размером (для проверки)
        String wrongSizeArr [][] = {
                {"1","2","4","5",},
                {"5","6","7","13","15","17"},
                {"9","10","11","12"},
                {"12","13","14","15"}};
        // массив с невеным типом данных (для проверки)
        String wrongDataArr [][] = {
                {"1","2","3","4"},
                {"5","6","7","5"},
                {"9","10","шш","12"},
                {"13","14","15","16"}};

        // блок try/catch для перехвата исключения либо Size,Data или общее исключение от класса Exception
        try {
            entArray(correctArr1, correctArr1);
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
    public static void entArray (String [][] mainArr, String [][] checkArr) throws MyArraySizeException, MyArrayDataException {

        if (mainArr.length != checkArr.length){
            throw new MyArraySizeException("Количество строк подаваемого массива - " + mainArr.length);
        }
        for (int i = 0; i < checkArr.length; i++){
            if (mainArr[i].length != 4) throw new MyArraySizeException("Длинна строки №" + (i+1) + " подаваемого массива - "  + mainArr[i].length);
        }

        // проверка на размер массива и выброс исключения MyArraySizeException, если массив не подходит

        // агрегатор чисел (счетчик)
        int sum = 0;
        // цикл который переводит из Str в int и записывает в переменную счетчик
        for(int i = 0; i < mainArr.length; i++){
            for (int j = 0; j < mainArr[0].length; j++){
                try {
                    sum += Integer.parseInt(mainArr[i][j]);
                } catch (Exception e){
                    throw new MyArrayDataException((i+1),(j+1));
                }
            }
        }
        // вывод на экран корректного результата работы: цикл и сумма элементов
        System.out.println("На вход подан массив - " + Arrays.deepToString(mainArr));
        System.out.println("Сумма элементов массива равна - " + sum);
    }
}
