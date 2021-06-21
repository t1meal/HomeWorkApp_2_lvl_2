import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // правильный массив
        String correctArr [][] = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}};
        // массив с неверным размером (для проверки)
        String wrongSizeArr [][] = {
                {"1","2","4",},
                {"5","6","7",},
                {"9","10","11",},
                {"12","13","14",}};
        // массив с невеным типом данных (для проверки)
        String wrongDataArr [][] = {
                {"1","2","3","4"},
                {"5","6","7","5"},
                {"9","10","шш","12"},
                {"13","14","15","16"}};

        // блок try/catch для перехвата исключения либо Size,Data или общее исключение от класса Exception
        try {
            entArray(correctArr, correctArr);
//            entArray(wrongSizeArr, correctArr);
//            entArray(wrongDataArr, correctArr);
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

        // проверка на размер массива и выброс исключения MyArraySizeException, если массив не подходит
        if (mainArr.length != checkArr.length || mainArr[0].length != checkArr[0].length){
            throw new MyArraySizeException("Длинна подаваемого массива - " + mainArr.length + "х" + mainArr[0].length);
        }
        // агрегатор чисел (счетчик)
        int sum = 0;
        // цикл который переводит из Str в int и записывает в переменную счетчик
        for(int i = 0; i < mainArr.length; i++){
            for (int j = 0; j < mainArr[0].length; j++){
                try {
                    sum += Integer.parseInt(mainArr[i][j]);
                } catch (Exception e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        // вывод на экран корректного результата работы: цикл и сумма элементов
        System.out.println("На вход подан массив - " + Arrays.deepToString(mainArr));
        System.out.println("Сумма элементов массива равна - " + sum);
    }
}
