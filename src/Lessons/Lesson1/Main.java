package Lessons.Lesson1;

public class Main extends Shape {
  public static void main(String[] args) {
    //Пример использования пречисления (enum) в Java
    for (Fruit fruit : Fruit.values()) {
      System.out.printf("Средний вес фрукта %s составляет: %d ед.\n", fruit.getRussianTitle(), fruit.getWeight());
    }
    //Во всех перечислениях присутствуют методы: values() — возвращает массив, содержащий список констант,
    // и valueOf(String str) — константу перечисления, значение которой соответствует строке аргументу str. Пример использования этих методов:

    //Определив перечисление, можно создавать переменные этого типа, подобно созданию переменных примитивных типов, то есть без использования оператора new.
    Fruit fruit = Fruit.APPLE;
    System.out.println(fruit);
    if (fruit == Fruit.APPLE) {
      System.out.println("fruit действительно является яблоком");
    }
    switch (fruit) {
      case APPLE:
        System.out.println("fruit - яблоко");
        break;
      case ORANGE:
        System.out.println("fruit - апельсин");
        break;
      case CHERRY:
        System.out.println("fruit - вишня");
        break;
    }

  }

  //реализуем метод абстрактного класса
  @Override
  boolean isPrintable() {
    return false;
  }

  //Пример создания анонимного класса
  Shape shape1 = new Shape() {
    @Override
    boolean isPrintable() {
      return false;
    }
  };

}
