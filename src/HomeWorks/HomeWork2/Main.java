package HomeWorks.HomeWork2;

public class Main {

  public static final int MAX_SIZE = 4;

//1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
//Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
//должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.

//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.

  public static void main(String[] args)  {
    String[][] myWrongArray = new String[][]{{"1", "2", "3", "4"},
                                             {"1", "2", "5", "4"},
                                             {"1", "2", "3", "4"},
                                             {"1", "2", "3", "4"},
                                             {"1", "2", "3", "4"}};

    String[][] myArray = new String[][]{{"1", "2", "3", "4"},
                                        {"1", "2", "Ё", "4"},
                                        {"1", "2", "3", "4"},
                                        {"1", "2", "3", "4"}};

    String[][] myArray2 = new String[][]{ {"1", "2", "3", "4"},
                                          {"1", "2", "3", "4"},
                                          {"1", "2", "3", "4"},
                                          {"1", "2", "3", "4"}};

    try {
      System.out.println("Сумма элементов равна: "+myMethod(myArray2));
      System.out.println();
      System.out.println("Сумма элементов равна: "+myMethod(myWrongArray));
      System.out.println();
      System.out.println("Сумма элементов равна: "+myMethod(myArray));

    } catch (MyArrayDataException e) {
      //3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
      System.out.println(e.getMessage());
    }

  }

  //1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
  public static int myMethod(String[][] myArray) throws MyArrayDataException {
    int summa = 0;
    // при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    if ((myArray.length > MAX_SIZE || myArray[0].length > MAX_SIZE)) {
      try {
        throw new MyArraySizeException("Размер должен быть 4x4");
      } catch (MyArraySizeException e) {
        System.out.println(e.getMessage());
      }
    } else {
      for (int i = 0; i < myArray.length; i++) {
        for (int j = 0; j < myArray[i].length; j++) {
          System.out.printf("%2s",myArray[i][j]);
          try {
            summa += Integer.parseInt(myArray[i][j]);
          } catch (NumberFormatException e) {
            System.out.println();
            throw new MyArrayDataException("В строке: " + (i+1) + ", колонке: " + (j+1) + ", находится символ: "  + myArray[i][j], summa);
          }
        }
        System.out.println();
      }
    }
    return summa;
  }
}
