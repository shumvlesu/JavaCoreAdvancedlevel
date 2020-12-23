package Lessons.Lesson1;

public class Main {
  public static void main(String[] args) {
    //Пример использования пречисления (enum) в Java
    for(Fruit fruit : Fruit.values()) {
      System.out.printf("Средний вес фрукта %s составляет: %d ед.\n", fruit.getRussianTitle(), fruit.getWeight());
    }
  }
}
