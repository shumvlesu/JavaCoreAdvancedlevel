package HomeWorks.HomeWork2;

public class Main {

  public static final int MAX_SIZE = 4;

//1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
//Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
//должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.

//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.

  public static void main(String[] args) {
    String[][] myArray = new String[][]{{"1", "2", "3", "4"},
                                        {"1", "2", "Ё", "4"},
                                        {"1", "2", "3", "4"},
                                        {"1", "2", "3", "4"}};

    myMethod(myArray);
  }

  //1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
  public static void myMethod(String[][] myArray) {
    if (myArray[0].length > MAX_SIZE || myArray.length > MAX_SIZE) {
      try {
        throw new MyArraySizeException("Размер должен быть 4x4");
      } catch (MyArraySizeException e) {
        e.printStackTrace();
      }
    }
  }


}
